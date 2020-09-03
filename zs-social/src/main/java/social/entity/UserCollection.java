package social.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * app用户收藏表
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-23
 */
@TableName("zs_user_collection")
public class UserCollection extends Model<UserCollection> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "ucid", type = IdType.AUTO)
    private Long ucid;

    /**
     * 收藏的用户uid
     */
    private Long uid;

    /**
     * 收藏类型： 1---回答  3---话题   4---评论
     */
    @TableField("collection_type")
    private Integer collectionType;

    /**
     * 收藏的数据的主键id
     */
    @TableField("data_id")
    private Long dataId;

    /**
     * 预留字段
     */
    private String ext;

    /**
     * 收藏时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getUcid() {
        return ucid;
    }

    public void setUcid(Long ucid) {
        this.ucid = ucid;
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Integer getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(Integer collectionType) {
        this.collectionType = collectionType;
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
        return this.ucid;
    }

    @Override
    public String toString() {
        return "UserCollection{" +
        "ucid=" + ucid +
        ", uid=" + uid +
        ", collectionType=" + collectionType +
        ", dataId=" + dataId +
        ", ext=" + ext +
        ", createTime=" + createTime +
        "}";
    }
}
