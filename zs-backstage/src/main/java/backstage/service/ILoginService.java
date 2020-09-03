package backstage.service;

import backstage.model.dto.admin.AdminLoginDto;
import backstage.model.vo.admin.AdminVo;
import backstage.model.vo.admin.ResultLoginVo;
import wrapper.Wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/13 0013 22:39
 * @description 用户登录服务类
 */
public interface ILoginService {

    /**
     * 后台登录
     *
     * @param adminLoginDto
     * @param request
     * @param response
     * @return the result login vo
     */
    ResultLoginVo adminLogin(AdminLoginDto adminLoginDto, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据token获取用户信息
     *
     * @param token
     * @return the admin vo
     */
    Wrapper<AdminVo> getAdminByToken(String token) throws IOException;

    /**
     * 刷新token
     *
     * @param accessToken
     * @param request
     * @param response
     * @return the string
     */
    String refreshToken(String accessToken, HttpServletRequest request, HttpServletResponse response);
}
