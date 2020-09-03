package backstage.mapper;

import backstage.entity.Menus;
import backstage.model.dto.menu.UserMenuDto;
import backstage.model.vo.menu.UserFirstMenuVo;
import backstage.model.vo.menu.UserMenuVo;
import backstage.model.vo.menu.UserSencondMenuVo;
import result.vo.admin.MenuResult;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import result.vo.admin.RoleMode;
import result.vo.admin.RolePage;
import result.vo.admin.RolesDeatilResult;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
public interface MenusMapper extends BaseMapper<Menus> {

	List<MenuResult> getMenus(@Param(value="uaid") Long uaid);

	List<RolesDeatilResult> getUserMenus(@Param(value="roleId")  Long roleId);

	List<UserSencondMenuVo> getUserSecondMenus(@Param(value="userMenuDto") UserMenuDto userMenuDto);

	UserMenuVo getUserFirstMenus(@Param(value="menuId")Long menuId);

	List<Long> getUserFirstMenuIds(@Param(value = "roleId") Long roleId);
}
