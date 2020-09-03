package backstage.model.vo.menu;

import lombok.Data;

import java.util.List;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/17 10:53
 * @description TODO
 */
@Data
public class UserMenuVo {


    private Long mid;

    private String icon;

    private String menuCode;

    private String menuName;

    private String routeName;

    private List<UserSencondMenuVo> userSencondMenuVoList;

}
