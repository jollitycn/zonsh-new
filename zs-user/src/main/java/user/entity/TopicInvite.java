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
 * @since 2019-06-26
 */
@TableName("zs_topic_invite")
public class TopicInvite extends Model<TopicInvite> {

    private static final long serialVersionUID = 1L;

    /**
     * 邀请表id
     */
    @TableId(value = "iid", type = IdType.AUTO)
    private Long iid;

    /**
     * 被邀请用户uid
     */
    private Long uid;

    /**
     * 话题表id
     */
    private Long tid;

    /**
     * 1系统邀请  2用户邀请
     */
    private Integer type;

    /**
     * 邀请用户id，系统邀请暂时为0
     */
    @TableField("create_uid")
    private Long createUid;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getIid() {
        return iid;
    }

    public void setIid(Long iid) {
        this.iid = iid;
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Long getCreateUid() {
        return createUid;
    }

    public void setCreateUid(Long createUid) {
        this.createUid = createUid;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.iid;
    }

    @Override
    public String toString() {
        return "TopicInvite{" +
        "iid=" + iid +
        ", uid=" + uid +
        ", tid=" + tid +
        ", type=" + type +
        ", createUid=" + createUid +
        ", createTime=" + createTime +
        "}";
    }
}
