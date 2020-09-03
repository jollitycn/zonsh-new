package backstage.model.vo.admin;

import base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/12 20:00
 * @description The class Admin vo
 */
@Data
@ApiModel(value = "管理员vo")
@EqualsAndHashCode(callSuper = true)
public class AdminVo extends BaseVO {

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
}
