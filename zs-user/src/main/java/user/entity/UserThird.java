package user.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * <p>
 * 第三方登录表
 * </p>
 *
 * @author xc
 * @since 2019-05-28
 */

@TableName("zs_user_third")
public class UserThird extends Model<UserThird> {

    private static final long serialVersionUID = 1L;

    /**
     * 第三方登录账号id主键
     */
    @TableId(value = "uhid", type = IdType.AUTO)
    private Long uhid;

    /**
     * 关联zs_user主键
     */
    private Long uid;

    /**
     * 第三方登陆类型（WECHAT、QQ）
     */
    @TableField("third_type")
    private String thirdType;

    /**
     * 第三方应用的唯一标识（如：wx的openid）
     */
    @TableField("third_key")
    private String thirdKey;

    /**
     * 第三方应用的全局标识（如：wx的unoinid）
     */
    @TableField("third_key_all")
    private String thirdKeyAll;

    /**
     * 接口调用凭证
     */
    @TableField("access_token")
    private String accessToken;

    /**
     * 刷新凭证
     */
    @TableField("refresh_token")
    private String refreshToken;

    /**
     * 失效时间
     */
    @TableField("expires_in")
    private Long expiresIn;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    public Long getUhid() {
        return uhid;
    }

    public void setUhid(Long uhid) {
        this.uhid = uhid;
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    public String getThirdType() {
        return thirdType;
    }

    public void setThirdType(String thirdType) {
        this.thirdType = thirdType;
    }
    public String getThirdKey() {
        return thirdKey;
    }

    public void setThirdKey(String thirdKey) {
        this.thirdKey = thirdKey;
    }
    public String getThirdKeyAll() {
        return thirdKeyAll;
    }

    public void setThirdKeyAll(String thirdKeyAll) {
        this.thirdKeyAll = thirdKeyAll;
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.uhid;
    }

    @Override
    public String toString() {
        return "UserThird{" +
        "uhid=" + uhid +
        ", uid=" + uid +
        ", thirdType=" + thirdType +
        ", thirdKey=" + thirdKey +
        ", thirdKeyAll=" + thirdKeyAll +
        ", accessToken=" + accessToken +
        ", refreshToken=" + refreshToken +
        ", expiresIn=" + expiresIn +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
