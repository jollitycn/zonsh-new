package result.vo.activity;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/6/27 13:52
 */
public class AidAndTitleResult {
    /**
     * 主键，活动id
     */
    private Long aid;

    /**
     * 活动标题（主题）
     */
    private String activityTitle;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    @Override
    public String toString() {
        return "AidAndTitleResult{" +
                "aid=" + aid +
                ", activityTitle='" + activityTitle + '\'' +
                '}';
    }
}
