package backstage.service;

import backstage.entity.Menus;
import backstage.model.vo.menu.UserMenuVo;
import result.vo.admin.MenuResult;
import java.util.List;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
public interface IMenusService extends IService<Menus> {

	/**
	 * 根据用户信息获取系统菜单
	 * @param uaid
	 * @return
	 */
	List<MenuResult> getMenus(Long uaid);

	/**
	 * 根据用户角色获取菜单
	 *
	 * @param roleId
	 * @return
	 */
	List<UserMenuVo> getUserMenus(Long roleId);
}
