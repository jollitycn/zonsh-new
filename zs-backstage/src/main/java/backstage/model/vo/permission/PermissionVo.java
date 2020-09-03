package backstage.model.vo.permission;

import base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/11 15:11
 * @description The class permission vo
 */
@Data
@ApiModel(value = "操作权限vo")
@EqualsAndHashCode(callSuper = true)
public class PermissionVo extends BaseVO {

    /**
     * 操作权限id
     */
    @ApiModelProperty(value = "操作权限id")
    private Long pid;

    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id")
    private Long menuId;

    /**
     * 权限操作名称
     */
    @ApiModelProperty(value = "权限操作名称")
    private String permissionName;

    /**
     * 状态(0:开启 1:关闭)
     */
    @ApiModelProperty(value = "状态", example = "0:选中 1:未选中")
    private String status;
}
