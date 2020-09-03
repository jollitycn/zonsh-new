package backstage.model.dto.admin;

import dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/12 9:59
 * @description The Admin login dto
 */
@Data
@ApiModel(value = "管理员登录dto")
@EqualsAndHashCode(callSuper = true)
public class AdminLoginDto extends BaseDto {

    /**
     * 用户昵称
     */
//    @ApiModelProperty(value = "用户昵称")
//    private String nickName;
//
//    /**
//     * 用户手机号
//     */
//    @ApiModelProperty(value = "用户手机号")
//    private String phone;
    /**
     * 登录账号
     */
    @ApiModelProperty(value = "登录账号")
    @NotBlank(message = "账号不能为空")
    private String loginAccount;

    /**
     * 用户密码
     */
    @ApiModelProperty(value = "用户密码")
    @NotBlank(message = "密码不能为空")
    private String password;

}
