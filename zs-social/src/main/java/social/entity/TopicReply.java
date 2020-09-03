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
 * @since 2019-06-11
 */
@TableName("zs_topic_reply")
public class TopicReply extends Model<TopicReply> {

    private static final long serialVersionUID = 1L;

    /**
     * 回答表
     */
    @TableId(value = "trid", type = IdType.AUTO)
    private Long trid;

    /**
     * 话题id
     */
    private Long tid;

    /**
     * 回答内容
     */
    @TableField("reply_content")
    private String replyContent;

    /**
     * 状态(1:保存  2：发布)
     */
    private Integer status;

    /**
     * 1：（正常）2：（屏蔽）
     */
    private Integer type;

    /**
     * 创建人id
     */
    @TableField("create_id")
    private Long createId;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_id")
    private Long updateId;

    @TableField("update_time")
    private Date updateTime;

    public Long getTrid() {
        return trid;
    }

    public void setTrid(Long trid) {
        this.trid = trid;
    }
    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }
    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.trid;
    }

    @Override
    public String toString() {
        return "TopicReply{" +
        "trid=" + trid +
        ", tid=" + tid +
        ", replyContent=" + replyContent +
        ", status=" + status +
        ", type=" + type +
        ", createId=" + createId +
        ", createTime=" + createTime +
        ", updateId=" + updateId +
        ", updateTime=" + updateTime +
        "}";
    }
}
