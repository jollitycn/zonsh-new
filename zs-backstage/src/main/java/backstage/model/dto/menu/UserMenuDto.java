package backstage.model.dto.menu;

import dto.BaseDto;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/17 13:43
 * @description 用户二级菜单查询dto
 */
@Data
@ApiModel(value = "用户二级菜单查询dto")
@EqualsAndHashCode(callSuper = true)
public class UserMenuDto extends BaseDto {

    private Long pid;

    private Long roleId;
}
