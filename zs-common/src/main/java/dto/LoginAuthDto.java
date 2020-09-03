package dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/13 0013 18:18
 * @description The class Login auth dto.
 */
@Data
@ApiModel(value = "登录人信息")
public class LoginAuthDto extends BaseDto {

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
