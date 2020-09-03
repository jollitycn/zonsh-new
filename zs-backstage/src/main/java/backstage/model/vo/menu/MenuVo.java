package backstage.model.vo.menu;

import base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/10 10:45
 * @description The class Menu vo
 */
@Data
@ApiModel(value = "菜单列表vo")
@EqualsAndHashCode(callSuper = true)
public class MenuVo extends BaseVO {

    /**
     * 表id
     */
    @ApiModelProperty(value = "菜单id")
    private Long mid;

    /**
     * 菜单编码
     */
    @ApiModelProperty(value = "菜单编码")
    private String menuCode;

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    /**
     * 菜单级别
     */
    @ApiModelProperty(value = "菜单级别")
    private Integer menuLevel;

    /**
     * 菜单父id
     */
    @ApiModelProperty(value = "菜单父id")
    private Long pid;
}
