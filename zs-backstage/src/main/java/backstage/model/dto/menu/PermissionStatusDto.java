package backstage.model.dto.menu;

import dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/10 15:20
 * @description The class Resource status dto
 */
@Data
@ApiModel(value = "资源状态修改dto")
@EqualsAndHashCode(callSuper = true)
public class PermissionStatusDto extends BaseDto {

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    private Long rid;

    /**
     * 操作权限id
     */
    @ApiModelProperty(value = "操作权限id")
    private Long pid;

    /**
     * 状态(0:开启 1:关闭)
     */
    @ApiModelProperty(value = "状态",example = "0:选中 1:不选中")
    private String status;

}
