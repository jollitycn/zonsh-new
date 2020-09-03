package user.service;

import com.baomidou.mybatisplus.service.IService;
import result.vo.UserResult;
import user.entity.UserThird;

/**
 * <p>
 * 第三方登录表 服务类
 * </p>
 *
 * @author xc
 * @since 2019-06-10
 */
public interface IUserThirdService extends IService<UserThird> {

	/**
	 * 微信登录
	 * @param code 微信登录授权码
	 * @return
	 */
	UserResult wxLogin(String code);



}
