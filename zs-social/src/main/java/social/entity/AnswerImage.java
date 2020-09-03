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
@TableName("zs_answer_image")
public class AnswerImage extends Model<AnswerImage> {

    private static final long serialVersionUID = 1L;

    /**
     * 回答图片表主键
     */
    @TableId(value = "aiid", type = IdType.AUTO)
    private Long aiid;

    /**
     * 回答表id
     */
    private Long aid;

    /**
     * 图片路径
     */
    @TableField("image_url")
    private String imageUrl;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getAiid() {
        return aiid;
    }

    public void setAiid(Long aiid) {
        this.aiid = aiid;
    }
    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.aiid;
    }

    @Override
    public String toString() {
        return "AnswerImage{" +
        "aiid=" + aiid +
        ", aid=" + aid +
        ", imageUrl=" + imageUrl +
        ", sort=" + sort +
        ", createTime=" + createTime +
        "}";
    }
}
