package backstage.model.vo.admin;

import base.BaseVO;
import dto.LoginAuthDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import result.vo.admin.RoleMode;
import result.vo.admin.RolePage;

import java.util.List;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/12 9:58
 * @description The class Result login vo
 */
@Data
@ApiModel(value = "角色列表vo")
@EqualsAndHashCode(callSuper = true)
public class ResultLoginVo extends BaseVO {

    /**
     * 会话token
     */
    @ApiModelProperty(value = "会话token")
    private String token;

    /**
     * 用户昵称
     */
//    @ApiModelProperty(value = "用户昵称")
//    private String nickName;

    /**
     * 登录信息
     */
    @ApiModelProperty(value = "登录信息")
    private LoginAuthDto loginAuthDto;

//    /**
//     * 菜单集合
//     */
//    @ApiModelProperty(value = "菜单集合")
//    private List<RolesDeatilResult> menuList;

    /**
     * 菜单集合
     */
    @ApiModelProperty(value = "菜单集合")
    private List<RoleMode> menuResult;

    /**
     * 权限详情
     */
    @ApiModelProperty(value = "权限详情")
    private List<RolePage> rolePage;

//    private List<UserMenuVo> userMenuVoList;

}
