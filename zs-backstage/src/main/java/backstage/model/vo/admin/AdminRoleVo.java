package backstage.model.vo.admin;

import base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/9 17:23
 * @description The class Admin role vo
 */
@Data
@ApiModel(value = "角色列表vo")
@EqualsAndHashCode(callSuper = true)
public class AdminRoleVo extends BaseVO {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Long uaid;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "用户手机号")
    private String phone;

    /**
     * 状态(0:正常 1:冻结)
     */
    @ApiModelProperty(value = "状态", example = "(0:正常 1:冻结)")
    private String status;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;
}
