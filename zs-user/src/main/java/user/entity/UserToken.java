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
 * @since 2019-05-28
 */
@TableName("zs_user_token")
public class UserToken extends Model<UserToken> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户token表主键
     */
    @TableId(value = "utid", type = IdType.AUTO)
    private Long utid;

    /**
     * 用户id
     */
    private Long uid;

    /**
     * 语言 1中文 2英文
     */
    private Integer language;

    /**
     * 来自 1Android 2IOS 3OTHER
     */
    private Integer from;

    /**
     * token内容
     */
    @TableField("token_content")
    private String tokenContent;

    /**
     * 版本号
     */
    private String version;

    /**
     * 登录时间
     */
    @TableField("login_time")
    private Date loginTime;

    /**
     * 登出时间
     */
    @TableField("exit_time")
    private Date exitTime;

    /**
     * 状态 1登入 2登出
     */
    private Integer status;

    public Long getUtid() {
        return utid;
    }

    public void setUtid(Long utid) {
        this.utid = utid;
    }
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }
    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }
    public String getTokenContent() {
        return tokenContent;
    }

    public void setTokenContent(String tokenContent) {
        this.tokenContent = tokenContent;
    }
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.utid;
    }

    @Override
    public String toString() {
        return "UserToken{" +
        "utid=" + utid +
        ", uid=" + uid +
        ", language=" + language +
        ", from=" + from +
        ", tokenContent=" + tokenContent +
        ", version=" + version +
        ", loginTime=" + loginTime +
        ", exitTime=" + exitTime +
        ", status=" + status +
        "}";
    }
}
