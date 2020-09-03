package backstage.mapper;

import backstage.entity.Roles;
import result.vo.admin.RoleMode;
import result.vo.admin.RolePage;
import result.vo.admin.RolesDeatilResult;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
public interface RolesMapper extends BaseMapper<Roles> {

	List<RolesDeatilResult> getRoleDetail(@Param(value="rid") Long rid);

	List<RoleMode> getUserMenus(@Param(value="rid") Long rid);

	List<RolePage> getRole(@Param(value="rid") Long rid);
}
