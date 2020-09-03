package backstage.service.impl;

import backstage.entity.Admins;
import backstage.exceptions.AuthBizException;
import backstage.mapper.AdminsMapper;
import backstage.model.constant.admin.AdminStatusConstant;
import backstage.model.dto.admin.AdminLoginDto;
import backstage.model.vo.TokenVo;
import backstage.model.vo.admin.AdminVo;
import backstage.model.vo.admin.ResultLoginVo;
import backstage.service.ILoginService;
import backstage.service.IRolesService;
import backstage.utils.Md5Util;
import com.alibaba.fastjson.JSON;
import dto.LoginAuthDto;
import enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import result.vo.admin.RoleMode;
import result.vo.admin.RolePage;
import util.*;
import wrapper.WrapMapper;
import wrapper.Wrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/13 0013 22:40
 * @description 用户登录服务实现类
 */
@Slf4j
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private AdminsMapper adminsMapper;

    @Autowired
    private IRolesService rolesService;

 

    @Override
    public ResultLoginVo adminLogin(AdminLoginDto adminLoginDto, HttpServletRequest request, HttpServletResponse response) {
        //获取参数
        String loginAccount = adminLoginDto.getLoginAccount();
        String password = adminLoginDto.getPassword();

        //校验参数
//        if(PublicUtil.isEmpty(nickName) || PublicUtil.isEmpty(password)){
//            throw new AuthBizException(ErrorCodeEnum.AUTH10010006);
//        }

        //构建查询条件
//        Admins admins = new Admins();
//        admins.setNickName(loginAccount);
//        admins.setPassword(password);
        //支持手机或者昵称登录
        Admins selectOne = adminsMapper.queryUser(loginAccount);

        if(PublicUtil.isEmpty(selectOne)){
            throw new AuthBizException(ErrorCodeEnum.AUTH10010007);
        }

        //校验密码
        if (!Md5Util.matches(password,selectOne.getPassword())){
            throw new AuthBizException(ErrorCodeEnum.AUTH100100015);
        }

        //判断用户账号是否被冻结
        if(selectOne.getStatus().equals(AdminStatusConstant.FROZEN)){
            throw new AuthBizException(ErrorCodeEnum.AUTH10010008);
        }

        selectOne.setPassword(null);

        //唯一回话id
        String sessionId = PubUtils.uuid();
        TokenVo tokenVo = new TokenVo();
        tokenVo.setLoginAccount(loginAccount);
        tokenVo.setSessionId(sessionId);


        //登录成功，生成token
        String token = AESUtils.ecodes(JSON.toJSONString(tokenVo), AESUtils.encodeKey);

        //用户登录信息
        LoginAuthDto loginAuthDto = new LoginAuthDto();
        BeanUtils.copyProperties(selectOne,loginAuthDto);

        //用户菜单权限信息
        List<RoleMode> menuResult=rolesService.getUserMenus(selectOne.getRoleId());
//       List<UserMenuVo> userMenuVoList = iMenusService.getUserMenus(selectOne.getRoleId());
        
        //权限数据格式处理
        List<RolePage> roleList=rolesService.getRole(selectOne.getRoleId());
//        for (RoleMode roleMode : menuResult) {
//        	roleList.addAll(roleMode.getPageList());
//		}
        
        
        //用户信息写入redis 缓存过期时间15分钟
//        RedisAPIUtil.hSet(token,JSON.toJSONString(loginAuthDto));
//        RedisAPIUtil.hSetWithTime(token, JSON.toJSONString(loginAuthDto),24*60*60);

        //token写入cookie中 并设置cookie失效时间15分钟
        CookieUtils.setCookie(request,response,"TOKEN",token,-1);

        //返回结果
        ResultLoginVo resultLoginVo = new ResultLoginVo();
        BeanUtils.copyProperties(selectOne,resultLoginVo);
        resultLoginVo.setToken(token);
        resultLoginVo.setMenuResult(menuResult);
//        resultLoginVo.setUserMenuVoList(userMenuVoList);
        resultLoginVo.setRolePage(roleList);
        resultLoginVo.setLoginAuthDto(loginAuthDto);
        RedisAPIUtil.hSet(token,JSON.toJSONString(resultLoginVo));
        return resultLoginVo;
    }

    @Override
    public Wrapper<AdminVo> getAdminByToken(String token) throws IOException {
        //返回结果
        AdminVo adminVo = new AdminVo();
        //根据token获取用户信息
        String adminJson = RedisAPIUtil.hGet(token);
        //判断是否回话过期
        if(PublicUtil.isEmpty(adminJson)){
            return WrapMapper.wrap(400,"用户session已过期,请重新登录",adminVo);
        }
        //转成java对象
        LoginAuthDto loginAuthDto = JSON.parseObject(adminJson, LoginAuthDto.class);
//       Object jsonObject = JSON.parseObject(adminJson);
//        Admins admins = JacksonUtil.parseJsonWithFormat(adminJson, Admins.class);
        //刷新session过期时间  15分钟
        RedisAPIUtil.hSetWithTime(token,adminJson,15*60);
        //用户登录信息放入上下文
//        ThreadLocalMap.put(GlobalConstant.Sys.TOKEN_AUTH_TDO,loginAuthDto);
        BeanUtils.copyProperties(loginAuthDto,adminVo);

        //返回结果
        return WrapMapper.ok(adminVo);
    }

    @Override
    public String refreshToken(String accessToken, HttpServletRequest request, HttpServletResponse response) {
        //校验参数
        if(PublicUtil.isEmpty(accessToken)){
           throw new IllegalArgumentException(ErrorCodeEnum.GL99990003.msg());
        }

        //将token解密
        String dcodeToken = AESUtils.dcodes(accessToken, AESUtils.encodeKey);
        TokenVo tokenVo = null;
        //解析token
        try {
            tokenVo = JSON.parseObject(dcodeToken, TokenVo.class);
        }catch (Exception ex){
            log.info("token解析异常...");
            throw new IllegalArgumentException("token请求参数非法");
        }

        //构建查询条件
        Admins admins = new Admins();
        admins.setNickName(tokenVo.getLoginAccount());
        //校验此用户是否存在
        Admins selectOne = adminsMapper.selectOne(admins);
        if(PublicUtil.isEmpty(selectOne)){
            throw new AuthBizException(ErrorCodeEnum.AUTH10010007);
        }

        //用户信息
        selectOne.setPassword(null);
        LoginAuthDto loginAuthDto = new LoginAuthDto();
        BeanUtils.copyProperties(selectOne,loginAuthDto);

        //生成新的会话id
        String sessionId = PubUtils.uuid();
        tokenVo.setSessionId(sessionId);

        //生成新的token
        String newToken = AESUtils.ecodes(JSON.toJSONString(tokenVo), AESUtils.encodeKey);

        //用户信息写入redis 缓存过期时间15分钟
        RedisAPIUtil.hSetWithTime(newToken, JSON.toJSONString(loginAuthDto),15*60);

        //token写入cookie中 并设置cookie失效时间15分钟
        CookieUtils.setCookie(request,response,"TOKEN",newToken,30*60);

        //返回结果
        return newToken;
    }

}
