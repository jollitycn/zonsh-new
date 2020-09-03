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
 * banner信息表
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-06-27
 */
@TableName("zs_banner")
public class Banner extends Model<Banner> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "bid", type = IdType.AUTO)
    private Long bid;

    /**
     * banner关联的活动id
     */
    private Long aid;

    /**
     * 封面图片地址
     */
    @TableField("cover_url")
    private String coverUrl;

    /**
     * 浏览量
     */
    @TableField("view_count")
    private Long viewCount;

    /**
     * 排序字段
     */
    private Long sort;

    /**
     * 是否有效：1---未删除  0：删除
     */
    @TableField("enabled_flag")
    private Integer enabledFlag;

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

    /**
     * 类型：0---线上
     */
    @TableField("banner_type")
    private Integer bannerType;

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
    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }
    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
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
    public Integer getBannerType() {
        return bannerType;
    }

    public void setBannerType(Integer bannerType) {
        this.bannerType = bannerType;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    @Override
    protected Serializable pkVal() {
        return this.bid;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "bid=" + bid +
                ", aid=" + aid +
                ", coverUrl='" + coverUrl + '\'' +
                ", viewCount=" + viewCount +
                ", sort=" + sort +
                ", enabledFlag=" + enabledFlag +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                ", updateTime=" + updateTime +
                ", updateBy=" + updateBy +
                ", bannerType=" + bannerType +
                '}';
    }
}
