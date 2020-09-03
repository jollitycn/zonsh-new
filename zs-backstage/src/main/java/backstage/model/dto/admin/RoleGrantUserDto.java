package backstage.model.dto.admin;

import com.baomidou.mybatisplus.annotations.TableField;
import dto.BaseDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/9 16:17
 * @description The class Role grant user dto
 */
@Data
@ApiModel(value = "添加后台管理员dto")
@EqualsAndHashCode(callSuper = true)
public class RoleGrantUserDto extends BaseDto {

    /**
     * 当前用户id
     */
//    @ApiModelProperty(value = "当前用户id")
//    private Long uaid;

    /**
     * 角色id
     */
    @ApiModelProperty(value = "角色id")
    @NotNull(message = "角色不能为空")
    private Long roleId;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    @NotBlank(message = "用户昵称不能为空")
    private String nickName;

    /**
     * 用户手机号
     */
    @ApiModelProperty(value = "用户手机号")
    @NotBlank(message = "用户手机号不能为空")
    private String phone;
}
