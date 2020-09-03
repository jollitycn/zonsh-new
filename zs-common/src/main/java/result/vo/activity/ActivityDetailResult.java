package result.vo.activity;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动详情实体VO
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/6/26 16:08
 */
public class ActivityDetailResult implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 主键，活动id
     */
    private Long aid;

    /**
     * 活动编号（唯一）
     */
    private String activityNumber;

    /**
     * 活动标题（主题）
     */
    private String activityTitle;

    /**
     * 活动内容（说明）
     */
    private String activityContent;

    /**
     * 活动类型：0---线上  1---线下
     */
    private Integer activityType;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 发布时间
     */
    private Date releaseTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人名称
     */
    private String createUname;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUname() {
        return createUname;
    }

    public void setCreateUname(String createUname) {
        this.createUname = createUname;
    }

    @Override
    public String toString() {
        return "ActivityDetailResult{" +
                "aid=" + aid +
                ", activityNumber='" + activityNumber + '\'' +
                ", activityTitle='" + activityTitle + '\'' +
                ", activityContent='" + activityContent + '\'' +
                ", activityType=" + activityType +
                ", status=" + status +
                ", releaseTime=" + releaseTime +
                ", createTime=" + createTime +
                ", createUname='" + createUname + '\'' +
                '}';
    }
}
