package user.entity;

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
 * @since 2019-06-28
 */
@TableName("zs_message")
public class Message extends Model<Message> {

    private static final long serialVersionUID = 1L;

    /**
     * 消息主键id
     */
    @TableId(value = "mid", type = IdType.AUTO)
    private Long mid;

    /**
     * 类型  1小助手 2回答邀请 3互动  4关注
     */
    private Integer type;

    /**
     * 接收用户id
     */
    @TableField("from_uid")
    private Long fromUid;

    /**
     * 关联id 可能包含用户id 话题id 活动id 评论id，具体根据type判断
     */
    @TableField("relation_id")
    private Long relationId;

    /**
     * 消息标题
     */
    @TableField("message_title")
    private String messageTitle;

    /**
     * 消息内容
     */
    @TableField("message_content")
    private String messageContent;

    /**
     * 是否已读
     */
    @TableField("is_view")
    private Integer isView;

    /**
     * 创建用户id 可能包含系统用户
     */
    @TableField("create_uid")
    private Long createUid;

    /**
     * 创建用户类型 0用户 1官方管理员
     */
    @TableField("create_uid_type")
    private Integer createUidType;

    /**
     * 推送ID，(预留)
     */
    @TableField("push_id")
    private String pushId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Long getFromUid() {
        return fromUid;
    }

    public void setFromUid(Long fromUid) {
        this.fromUid = fromUid;
    }
    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }
    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }
    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
    public Integer getIsView() {
        return isView;
    }

    public void setIsView(Integer isView) {
        this.isView = isView;
    }
    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }
    public Integer getCreateUidType() {
        return createUidType;
    }

    public void setCreateUidType(Integer createUidType) {
        this.createUidType = createUidType;
    }
    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.mid;
    }

    @Override
    public String toString() {
        return "Message{" +
        "mid=" + mid +
        ", type=" + type +
        ", fromUid=" + fromUid +
        ", relationId=" + relationId +
        ", messageTitle=" + messageTitle +
        ", messageContent=" + messageContent +
        ", isView=" + isView +
        ", createUid=" + createUid +
        ", createUidType=" + createUidType +
        ", pushId=" + pushId +
        ", createTime=" + createTime +
        "}";
    }
}
