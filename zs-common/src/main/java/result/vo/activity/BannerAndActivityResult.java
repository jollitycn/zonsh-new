package result.vo.activity;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/6/27 17:11
 */
public class BannerAndActivityResult {
    /**
     * 主键id
     */
    private Long bid;

    /**
     * banner关联的活动id
     */
    private Long aid;
    /**
     * 封面图片地址
     */
    private String coverUrl;
    /**
     * 活动标题（主题）
     */
    private String activityTitle;
    /**
     * 类型：0---线上
     */
    private Integer bannerType;
    /**
     * 浏览量
     */
    private Long viewCount;

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public Integer getBannerType() {
        return bannerType;
    }

    public void setBannerType(Integer bannerType) {
        this.bannerType = bannerType;
    }

    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "BannerAndActivityResult{" +
                "bid=" + bid +
                ", aid=" + aid +
                ", coverUrl='" + coverUrl + '\'' +
                ", activityTitle='" + activityTitle + '\'' +
                ", bannerType=" + bannerType +
                ", viewCount=" + viewCount +
                '}';
    }
}
