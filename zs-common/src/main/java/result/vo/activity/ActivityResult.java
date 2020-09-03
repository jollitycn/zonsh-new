package result.vo.activity;

import java.util.Date;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/6/27 15:28
 */
public class ActivityResult {
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
     * 活动类型：0---线上  1---线下
     */
    private Integer activityType;

    /**
     * 状态---1：未发布（草稿、已下架），2：已发布（进行中、已上架）
     */
    private Integer status;

    /**
     * 发布时间
     */
    private Date releaseTime;

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

    @Override
    public String toString() {
        return "ActivityResult{" +
                "aid=" + aid +
                ", activityNumber='" + activityNumber + '\'' +
                ", activityTitle='" + activityTitle + '\'' +
                ", activityType=" + activityType +
                ", status=" + status +
                ", releaseTime=" + releaseTime +
                '}';
    }
}
