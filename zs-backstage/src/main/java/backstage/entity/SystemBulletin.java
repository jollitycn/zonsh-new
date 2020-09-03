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
 * 系统公告
 * </p>
 *
 * @author wj
 * @since 2019-07-25
 */
@TableName("zs_system_bulletin")
public class SystemBulletin extends Model<SystemBulletin> {

    private static final long serialVersionUID = 1L;

    /**
     * 系统公告主键id
     */
    @TableId(value = "bnid", type = IdType.AUTO)
    private Long bnid;

    /**
     * 公告编号
     */
    private String number;

    /**
     * 公告内容
     */
    @TableField("bulletin_content")
    private String bulletinContent;
    /**
     * 公告标题
     */
    @TableField("bulletin_title")
    private String bulletinTitle;

    /**
     * 浏览量
     */
    @TableField("browse_count")
    private Integer browseCount;

    /**
     * 状态（0---已删除  1---使用中  2----草稿 ）
     */
    private Integer status;

    /**
     * 发布时间
     */
    @TableField("release_time")
    private Date releaseTime;

    /**
     * 创建人id
     */
    @TableField("create_id")
    private Long createId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getBnid() {
        return bnid;
    }

    public void setBnid(Long bnid) {
        this.bnid = bnid;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    public String getBulletinContent() {
        return bulletinContent;
    }

    public void setBulletinContent(String bulletinContent) {
        this.bulletinContent = bulletinContent;
    }
    public Integer getBrowseCount() {
        return browseCount;
    }

    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }
    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBulletinTitle() {
        return bulletinTitle;
    }

    public void setBulletinTitle(String bulletinTitle) {
        this.bulletinTitle = bulletinTitle;
    }

    @Override
    protected Serializable pkVal() {
        return this.bnid;
    }

    @Override
    public String toString() {
        return "SystemBulletin{" +
                "bnid=" + bnid +
                ", number='" + number + '\'' +
                ", bulletinContent='" + bulletinContent + '\'' +
                ", bulletinTitle='" + bulletinTitle + '\'' +
                ", browseCount=" + browseCount +
                ", status=" + status +
                ", releaseTime=" + releaseTime +
                ", createId=" + createId +
                ", createTime=" + createTime +
                '}';
    }
}
