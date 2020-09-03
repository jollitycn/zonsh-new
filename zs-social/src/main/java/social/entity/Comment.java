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
 * 评论表
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-10
 */
@TableName("zs_comment")
public class Comment extends Model<Comment> {

    private static final long serialVersionUID = 1L;

    /**
     * 评论主键
     */
    @TableId(value = "cid", type = IdType.AUTO)
    private Long cid;

    /**
     * 评论人id
     */
    private Long uid;

    /**
     * 回答/活动id
     */
    private Long aid;

    /**
     * 评论的类型：1---回答  2---活动
     */
    @TableField("comment_type")
    private Integer commentType;

    /**
     * 评论内容
     */
    @TableField("comment_content")
    private String commentContent;

    /**
     * 数据类型：1---一级评论  2---二级评论  3---二级评论的回复
     */
    @TableField("data_type")
    private Integer dataType;

    /**
     * 上级评论的id
     */
    @TableField("parent_cid")
    private Long parentCid;

    /**
     * 被回复用户id，即上一级回复的uid，为空表示一个二级评论
     */
    @TableField("replied_uid")
    private Long repliedUid;

    /**
     * 全父cid(全父路径+自身cid)，以逗号结尾
     */
    @TableField("comment_code")
    private String commentCode;

    /**
     * 点赞数
     */
    @TableField("like_count")
    private Long likeCount;

    /**
     * 状态：0---已删除  1---使用中  2---屏蔽
     */
    private Integer status;

    /**
     * 评论时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }
    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }
    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }
    public Long getParentCid() {
        return parentCid;
    }

    public void setParentCid(Long parentCid) {
        this.parentCid = parentCid;
    }
    public Long getRepliedUid() {
        return repliedUid;
    }

    public void setRepliedUid(Long repliedUid) {
        this.repliedUid = repliedUid;
    }
    public String getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(String commentCode) {
        this.commentCode = commentCode;
    }
    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.cid;
    }

    @Override
    public String toString() {
        return "Comment{" +
        "cid=" + cid +
        ", uid=" + uid +
        ", aid=" + aid +
        ", commentType=" + commentType +
        ", commentContent=" + commentContent +
        ", dataType=" + dataType +
        ", parentCid=" + parentCid +
        ", repliedUid=" + repliedUid +
        ", commentCode=" + commentCode +
        ", likeCount=" + likeCount +
        ", status=" + status +
        ", createTime=" + createTime +
        "}";
    }
}
