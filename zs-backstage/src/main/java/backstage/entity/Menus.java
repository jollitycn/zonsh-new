package backstage.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 菜单表
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
@TableName("zs_menus")
public class Menus extends Model<Menus> {

    private static final long serialVersionUID = 1L;

    /**
     * 管理后台菜单表主键id
     */
    @TableId(value = "mid", type = IdType.AUTO)
    private Long mid;

    /**
     * 菜单编码
     */
    @TableField("menu_code")
    private String menuCode;

    /**
     * 菜单名称
     */
    @TableField("menu_name")
    private String menuName;

    /**
     * 图标
     */
    private String icon;

    /**
     * 菜单级别
     */
    @TableField("menu_level")
    private Integer menuLevel;

    /**
     * 描述
     */
    private String describe;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 排序值(预留字段)
     */
    private Integer sort;

    /**
     * 父菜单id 为空表示一级菜单
     */
    @TableField("parent_menu")
    private Integer parentMenu;

    /**
     * 创建人id
     */
    @TableField("create_by")
    private Long createBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 菜单路由名称
     */
    @TableField("route_name")
    private String routeName;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }
    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }
    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public Integer getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Integer parentMenu) {
        this.parentMenu = parentMenu;
    }
    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    @Override
    protected Serializable pkVal() {
        return this.mid;
    }

    @Override
    public String toString() {
        return "Menus{" +
        "mid=" + mid +
        ", menuCode=" + menuCode +
        ", menuName=" + menuName +
        ", icon=" + icon +
        ", menuLevel=" + menuLevel +
        ", describe=" + describe +
        ", url=" + url +
        ", sort=" + sort +
        ", parentMenu=" + parentMenu +
        ", createBy=" + createBy +
        ", createTime=" + createTime +
        ", routeName="+ routeName +
        "}";
    }
}
