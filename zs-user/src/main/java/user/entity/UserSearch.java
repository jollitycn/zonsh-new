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
 * @since 2019-07-10
 */
@TableName("zs_user_search")
public class UserSearch extends Model<UserSearch> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户搜索历史记录表主键id
     */
    @TableId(value = "sid", type = IdType.AUTO)
    private Long sid;

    /**
     * 搜索类型 1 话题 2活动
     */
    @TableField("search_type")
    private Integer searchType;

    /**
     * 搜索内容
     */
    @TableField("search_content")
    private String searchContent;

    /**
     * 创建用户id
     */
    @TableField("create_uid")
    private Long createUid;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }
    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }
    public String getSearchContent() {
        return searchContent;
    }

    public void setSearchContent(String searchContent) {
        this.searchContent = searchContent;
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
        return this.sid;
    }

    @Override
    public String toString() {
        return "UserSearch{" +
        "sid=" + sid +
        ", searchType=" + searchType +
        ", searchContent=" + searchContent +
        ", createUid=" + createUid +
        ", createTime=" + createTime +
        "}";
    }
}
