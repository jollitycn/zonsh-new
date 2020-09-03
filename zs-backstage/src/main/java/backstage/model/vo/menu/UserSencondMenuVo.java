package backstage.model.vo.menu;

import lombok.Data;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/17 10:37
 * @description TODO
 */
@Data
public class UserSencondMenuVo {

    private Long rdid;

    private Long pid;

    private String icon;

    private String menuCode;

    private String menuName;

    private String routeName;

    private String url;

    private Integer read;

    private Integer write;
}
