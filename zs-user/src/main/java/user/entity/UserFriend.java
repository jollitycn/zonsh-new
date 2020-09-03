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
 * app用户关注表
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-09
 */
@TableName("zs_user_friend")
public class UserFriend extends Model<UserFriend> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户关注关系表主键id
     */
    @TableId(value = "ufid", type = IdType.AUTO)
    private Long ufid;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 关注用户id
     */
    @TableField("follow_uid")
    private Long followUid;

    /**
     * 是否互相关注 0否 1是
     */
    @TableField("is_friend")
    private Integer isFriend;

    /**
     * 关注时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getUfid() {
        return ufid;
    }

    public void setUfid(Long ufid) {
        this.ufid = ufid;
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Long getFollowUid() {
        return followUid;
    }

    public void setFollowUid(Long followUid) {
        this.followUid = followUid;
    }
    public Integer getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(Integer isFriend) {
        this.isFriend = isFriend;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.ufid;
    }

    @Override
    public String toString() {
        return "UserFriend{" +
        "ufid=" + ufid +
        ", uid=" + uid +
        ", followUid=" + followUid +
        ", isFriend=" + isFriend +
        ", createTime=" + createTime +
        "}";
    }
}
