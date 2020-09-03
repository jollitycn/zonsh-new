package backstage.model.dto.admin;

import dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/13 0013 22:12
 * @description The Modify account dto
 */
@Data
@ApiModel(value = "账号操作dto")
@EqualsAndHashCode(callSuper = true)
public class ModifyAccountDto extends BaseDto {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    @NotNull(message = "参数不能为空")
    private Long uaid;

    /**
     * 当前登录用户id
     */
//    @ApiModelProperty(value = "当前登录用户id")
//    @NotNull(message = "参数不能为空")
//    private Long currentUserId;
    /**
     * 用户状态
     */
    @ApiModelProperty(value = "用户状态")
    @NotBlank(message = "参数不能为空")
    private String status;
}
