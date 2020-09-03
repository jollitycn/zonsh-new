package backstage.model.dto.permission;

import dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/11 20:59
 * @description The class Role menu dto
 */
@Data
@ApiModel(value = "角色菜单dto")
@EqualsAndHashCode(callSuper = true)
public class RoleMenuDto extends BaseDto {

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Long rid;

    /**
     * 菜单id
     */
    @ApiModelProperty(value = "菜单id")
    private Long mid;
}
