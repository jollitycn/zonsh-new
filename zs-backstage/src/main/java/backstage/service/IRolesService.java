package backstage.service;

import backstage.entity.Roles;
import request.admin.RoleParam;
import result.vo.admin.RoleMode;
import result.vo.admin.RolePage;
import result.vo.admin.RolesDeatilResult;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
public interface IRolesService extends IService<Roles> {

	/**
	 * 获取角色权限详情
	 * @param rid
	 * @return
	 */
	List<RolesDeatilResult> getRoleDetail(Long rid);

	/**
	 * 更改角色权限
	 * @param roleParam
	 * @return
	 */
	Boolean changeRoleDetail(RoleParam roleParam);

	/**
	 * 根据角色id获取用户的菜单
	 * @param roleId
	 * @return
	 */
	List<RoleMode> getUserMenus(Long roleId);

	/**
	 * 获取角色权限
	 * @param roleId
	 * @return
	 */
	List<RolePage> getRole(Long roleId);

}
