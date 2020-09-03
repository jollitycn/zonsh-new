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
 * app用户点赞记录表
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-23
 */
@TableName("zs_user_like")
public class UserLike extends Model<UserLike> {

    private static final long serialVersionUID = 1L;

    /**
     * 点赞主键id
     */
    @TableId(value = "lid", type = IdType.AUTO)
    private Long lid;

    /**
     * 点赞的用户uid
     */
    private Long uid;

    /**
     * 点赞类型： 1---回答  2---活动  3---话题   4---评论
     */
    @TableField("like_type")
    private Integer likeType;

    /**
     * 点赞对象的主键id
     */
    @TableField("data_id")
    private Long dataId;

    /**
     * 预留字段
     */
    private String ext;

    /**
     * 点赞时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Integer getLikeType() {
        return likeType;
    }

    public void setLikeType(Integer likeType) {
        this.likeType = likeType;
    }
    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }
    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.lid;
    }

    @Override
    public String toString() {
        return "UserLike{" +
        "lid=" + lid +
        ", uid=" + uid +
        ", likeType=" + likeType +
        ", dataId=" + dataId +
        ", ext=" + ext +
        ", createTime=" + createTime +
        "}";
    }
}
