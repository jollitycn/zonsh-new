package backstage.model.vo.resource;

import base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/10 14:03
 * @description The class Resource vo
 */
@Data
@ApiModel(value = "资源vo")
@EqualsAndHashCode(callSuper = true)
public class ResourceVo extends BaseVO {

    /**
     * 按钮id
     */
    @ApiModelProperty(value = "按钮id")
    private Long rid;

    /**
     * 权限编码
     */
    @ApiModelProperty(value = "权限编码")
    private String resourceCode;

    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    private String resourceName;

    /**
     * 资源类型( 0:按钮(BUTTON) 1:链接(URL) )
     */
    @ApiModelProperty(value = "资源类型",example = "0:按钮(BUTTON) 1:链接(URL)")
    private String resourceType;

    /**
     * 状态(0:开启 1:关闭)
     */
    @ApiModelProperty(value = "状态",example = "0:开启(选中) 1:关闭(未选中)")
    private String status;

    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id")
    private Long menuId;
}
