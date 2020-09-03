package backstage.model.vo.role;

import base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/9 14:17
 * @description The class Role list vo
 */
@Data
@ApiModel(value = "角色列表vo")
@EqualsAndHashCode(callSuper = true)
public class RoleListVo extends BaseVO {

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Long rid;

    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    private String roleCode;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 角色类型(0:系统角色 1:app角色)
     */
    @ApiModelProperty(value = "角色类型",example = "(0:系统角色 1:app角色)")
    private String roleType;
}
