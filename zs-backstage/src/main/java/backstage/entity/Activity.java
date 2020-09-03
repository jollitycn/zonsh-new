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
 * 活动信息表
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-06-26
 */
@TableName("zs_activity")
public class Activity extends Model<Activity> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，活动id
     */
    @TableId(value = "aid", type = IdType.AUTO)
    private Long aid;

    /**
     * 活动编号（唯一）
     */
    @TableField("activity_number")
    private String activityNumber;

    /**
     * 活动标题（主题）
     */
    @TableField("activity_title")
    private String activityTitle;

    /**
     * 活动内容（说明）
     */
    @TableField("activity_content")
    private String activityContent;

    /**
     * 活动需要跳转的地址
     */
    @TableField("activity_url")
    private String activityUrl;

    /**
     * 活动类型：0---线上  1---线下
     */
    @TableField("activity_type")
    private Integer activityType;

    /**
     * 状态---1：未启动（草稿、已下架），2：进行中（已发布、已上架）
     */
    private Integer status;

    /**
     * 发布时间
     */
    @TableField("release_time")
    private Date releaseTime;

    /**
     * 参与人数
     */
    @TableField("join_count")
    private Long joinCount;

    /**
     * 排序字段
     */
    private Long sort;

    /**
     * 拓展字段
     */
    private String ext;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 创建人id
     */
    @TableField("create_by")
    private Long createBy;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 修改人id
     */
    @TableField("update_by")
    private Long updateBy;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }
    public String getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(String activityNumber) {
        this.activityNumber = activityNumber;
    }
    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }
    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }
    public String getActivityUrl() {
        return activityUrl;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl;
    }
    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
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
    public Long getJoinCount() {
        return joinCount;
    }

    public void setJoinCount(Long joinCount) {
        this.joinCount = joinCount;
    }
    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }
    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    protected Serializable pkVal() {
        return this.aid;
    }

    @Override
    public String toString() {
        return "Activity{" +
        "aid=" + aid +
        ", activityNumber=" + activityNumber +
        ", activityTitle=" + activityTitle +
        ", activityContent=" + activityContent +
        ", activityUrl=" + activityUrl +
        ", activityType=" + activityType +
        ", status=" + status +
        ", releaseTime=" + releaseTime +
        ", joinCount=" + joinCount +
        ", sort=" + sort +
        ", ext=" + ext +
        ", createTime=" + createTime +
        ", createBy=" + createBy +
        ", updateTime=" + updateTime +
        ", updateBy=" + updateBy +
        "}";
    }
}
