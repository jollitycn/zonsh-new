package backstage.service.impl;

import backstage.entity.Admins;
import backstage.exceptions.AuthBizException;
import backstage.mapper.AdminsMapper;
import backstage.model.constant.admin.AdminStatusConstant;
import backstage.model.dto.admin.AdminQueryDto;
import backstage.model.dto.admin.ModifyAccountDto;
import backstage.model.dto.admin.RoleGrantUserDto;
import backstage.model.vo.admin.AdminRoleVo;
import backstage.service.IAdminsService;
import backstage.utils.Md5Util;
import constant.Constant;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import dto.LoginAuthDto;
import enums.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 后台管理员表 服务实现类
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
@Service
@Slf4j
public class AdminsServiceImpl extends ServiceImpl<AdminsMapper, Admins> implements IAdminsService {

    @Autowired
    private AdminsMapper adminsMapper;

    @Override
    public Page<AdminRoleVo> queryAdminWithPage(AdminQueryDto adminQueryDto) {
        //参数校验
        if(PublicUtil.isEmpty(adminQueryDto)){
            throw new IllegalArgumentException(ErrorCodeEnum.GL99990003.msg());
        }

        //构建返回结果
        Page<AdminRoleVo> voPage = new Page<>();
        int pageNum = adminQueryDto.getPageNum();
        //分页参数
        voPage.setCurrent(pageNum);
        voPage.setSize(adminQueryDto.getPageSize());
        adminQueryDto.setPageNum((pageNum - 1)*adminQueryDto.getPageSize());

        //查询记录
        List<AdminRoleVo> adminList = adminsMapper.listAdmin(adminQueryDto);

        //统计记录数
        Long count = adminsMapper.countAdmin(adminQueryDto);

        //封装剩余参数
        voPage.setRecords(adminList);
        voPage.setTotal(count);

        //返回结果
        return voPage;
    }

    @Override
    public Integer modifyAdminAccount(ModifyAccountDto modifyAccountDto, LoginAuthDto loginAuthDto) {
        //校验参数
        if(PublicUtil.isEmpty(modifyAccountDto)){
            throw new IllegalArgumentException(ErrorCodeEnum.GL99990003.msg());
        }

        //获取参数
//        Long currentUserId = modifyAccountDto.getCurrentUserId();
        Long currentUserId = loginAuthDto.getUaid();
        Long uaid = modifyAccountDto.getUaid();
        String status = modifyAccountDto.getStatus();
        if (currentUserId.intValue() != Constant.SUPER_MANAGER_USER_ID.intValue()){
            throw new AuthBizException(ErrorCodeEnum.AUTH100100010);
        }

        //不能冻结超级管理员账号
        if(uaid.intValue() == Constant.SUPER_MANAGER_USER_ID.intValue()){
            throw new AuthBizException(ErrorCodeEnum.AUTH100100011);
        }

        //构建更新条件
        Admins admins = new Admins();
        admins.setUaid(uaid);
        admins.setStatus(status);
        admins.setUpdateTime(new Date());
        EntityWrapper<Admins> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("uaid",uaid);

        Integer result = adminsMapper.updateById(admins);
        if(result < 1){
            throw new AuthBizException(ErrorCodeEnum.AUTH10010003);
        }

        //返回结果
        return result;
    }

    @Override
    public Integer addBackstageAdmin(RoleGrantUserDto roleGrantUserDto, LoginAuthDto loginAuthDto) {
        //定义返回结果
        Integer result = null;
        //参数校验
        if(PublicUtil.isEmpty(roleGrantUserDto)){
//            throw new AuthBizException(ErrorCodeEnum.GL99990003);
            throw new IllegalArgumentException(ErrorCodeEnum.GL99990003.msg());
        }

//        log.info("非超级管理员,不能操作...");
        //判断当前用户是否为超管
        if(loginAuthDto.getUaid().intValue() != Constant.SUPER_MANAGER_USER_ID){
            throw new AuthBizException(ErrorCodeEnum.AUTH100100010);
        }
        
        //校验手机号是否存在
        Admins judgePhone = new Admins();
        judgePhone.setPhone(roleGrantUserDto.getPhone());
        Admins repeatedPhone = adminsMapper.selectOne(judgePhone);
        if(PublicUtil.isNotEmpty(repeatedPhone)){
            throw new AuthBizException(ErrorCodeEnum.AUTH100100016);
        }

        //校验昵称是否重复
        Admins nickName = new Admins();
        nickName.setNickName(roleGrantUserDto.getNickName());
        Admins repeatedNickName = adminsMapper.selectOne(nickName);
        if(PublicUtil.isNotEmpty(repeatedNickName)){
            throw new AuthBizException(ErrorCodeEnum.AUTH100100017);
        }

        //先新增管理员
//        Admin admin = new Admin();
        Admins admins = new Admins();
        //设定默认密码
        admins.setPassword(Md5Util.encrypt("21232f297a57a5a743894a0e4a801fc3"));
        //默认账号正常
        admins.setStatus(AdminStatusConstant.NORMAL);
        //属性克隆
        BeanUtils.copyProperties(roleGrantUserDto,admins);
        admins.setCreateTime(LocalDateTimeUtils.convertLDTToDate(LocalDateTime.now()));
        admins.setCreateBy(loginAuthDto.getUaid());
        result = adminsMapper.insert(admins);
        if(result < 1){
            throw new AuthBizException(ErrorCodeEnum.AUTH10010002);
        }

        //TODO 现在用户只有一个角色(一对一)

        //返回结果
        return result;
    }

	@Override
	public Page<AdminRoleVo> getAdminList(Integer pageNum, Integer pageSize, Integer status,String searchKey) {
		 //构建返回结果
        Page<AdminRoleVo> page = new Page<>(pageNum,pageSize);
        
        if(StringUtils.isNotEmpty(searchKey)){
        	searchKey="%"+searchKey+"%";
        }
        
		return page.setRecords(baseMapper.getAdminList(page,status,searchKey));
	}
}
