package backstage.web.webapi;

import backstage.model.dto.admin.AdminLoginDto;
import backstage.model.vo.admin.ResultLoginVo;
import backstage.service.ILoginService;
import backstage.web.webapi.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import wrapper.WrapMapper;
import wrapper.Wrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/12 9:19
 * @description 后台管理员登录前端控制器
 */
@Slf4j
@RestController
@RequestMapping(value = "/login",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "LoginController",tags = {"登录接口"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminLoginController extends BaseController {


    @Autowired
    private ILoginService iLoginService;

    /**
     * 后台登录
     *
     * @param adminLoginDto
     * @return the wrapper
     */
    @PostMapping(value = "/webLogin")
    @ApiOperation(httpMethod = "POST",value = "后台登录")
    public Wrapper<ResultLoginVo> webLogin(@ApiParam(name = "adminLoginDto",value = "管理员登录dto") @RequestBody @Valid AdminLoginDto adminLoginDto, HttpServletRequest request, HttpServletResponse response){
        log.info("后台登录 adminLoginDto={}",adminLoginDto);
        ResultLoginVo result = iLoginService.adminLogin(adminLoginDto,request,response);
        return WrapMapper.ok(result);
    }

//    /**
//     * 根据token获取用户信息
//     *
//     * @param token
//     * @return the wrapper
//     */
//    @GetMapping(value = "/getAdminByToken/{token}")
//    @ApiOperation(httpMethod = "GET",value = "根据token获取用户信息")
//    public Wrapper<AdminVo> getAdminByToken(@ApiParam(name = "token",value = "用户token") @PathVariable String token) throws IOException {
//        log.info("根据token获取用户信息 token={}",token);
//        Wrapper<AdminVo> adminVoWrapper = iLoginService.getAdminByToken(token);
//        return adminVoWrapper;
//    }

//    /**
//     * 刷新token
//     *
//     * @param accessToken
//     * @return the wrapper
//     */
//    @GetMapping(value = "/refreshToken/{accessToken}")
//    @ApiOperation(httpMethod = "GET",value = "刷新token")
//    public Wrapper<String> refreshToken(@ApiParam(name = "accessToken",value = "访问token") @PathVariable String accessToken,HttpServletRequest request, HttpServletResponse response){
//        log.info("刷新token accessToken={}",accessToken);
//        String newToken = iLoginService.refreshToken(accessToken,request,response);
//        return WrapMapper.ok(newToken);
//    }
}
