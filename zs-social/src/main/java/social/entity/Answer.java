package social.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xc
 * @since 2019-06-12
 */
@TableName("zs_answer")
public class Answer extends Model<Answer> {

    private static final long serialVersionUID = 1L;

    /**
     * 问题回答表主键id
     */
    @TableId(value = "aid", type = IdType.AUTO)
    private Long aid;

    /**
     * 话题/问题id
     */
    private Long tid;

    /**
     * 回答者用户id
     */
    private Long uid;

    /**
     * 回答编号
     */
    @TableField("answer_number")
    private String answerNumber;

    /**
     * 回答标题
     */
    @TableField("answer_title")
    private String answerTitle;

    /**
     * 回答内容
     */
    @TableField("answer_content")
    private String answerContent;

    /**
     * 状态 0正常 1草稿 2屏蔽
     */
    private Integer status;

    /**
     * 来源 1话题 2活动
     */
    private Integer from;
    
    /**
     *  排序值
     */
    private Double sort;

    /**
     * 点赞数
     */
    @TableField("like_count")
    private Long likeCount;

    /**
     * 阅读数
     */
    @TableField("view_count")
    private Long viewCount;

    /**
     * 发布时间
     */
    @TableField("release_time")
    private Date releaseTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    
    
    public Double getSort() {
		return sort;
	}

	public void setSort(Double sort) {
		this.sort = sort;
	}

	public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }
    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    public String getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(String answerNumber) {
        this.answerNumber = answerNumber;
    }
    public String getAnswerTitle() {
        return answerTitle;
    }

    public void setAnswerTitle(String answerTitle) {
        this.answerTitle = answerTitle;
    }
    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }
    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }
    public Long getViewCount() {
        return viewCount;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }
    public Date getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.aid;
    }

    @Override
    public String toString() {
        return "Answer{" +
        "aid=" + aid +
        ", tid=" + tid +
        ", uid=" + uid +
        ", answerNumber=" + answerNumber +
        ", answerTitle=" + answerTitle +
        ", answerContent=" + answerContent +
        ", status=" + status +
        ", from=" + from +
        ", likeCount=" + likeCount +
        ", viewCount=" + viewCount +
        ", releaseTime=" + releaseTime +
        ", updateTime=" + updateTime +
        ", createTime=" + createTime +
        "}";
    }
}
