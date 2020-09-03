package backstage.model.vo.menu;

import backstage.model.vo.permission.PermissionVo;
import base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/11 15:33
 * @description The class Role menus vo
 */
@Data
@ApiModel(value = "角色菜单列表vo")
@EqualsAndHashCode(callSuper = true)
public class RoleMenusVo extends BaseVO {

    /**
     * 角色菜单列表集合
     */
    @ApiModelProperty(value = "角色菜单列表集合")
    private List<RoleMenuVo> roleMenuVoList;

    /**
     * 角色操作权限集合
     */
    @ApiModelProperty(value = "角色操作权限集合")
    private List<PermissionVo> permissionVoList;
}
