package backstage.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 后台管理员表
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
@TableName("zs_admins")
public class Admins extends Model<Admins> {

    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    @TableId(value = "uaid", type = IdType.AUTO)
    private Long uaid;

    /**
     * 管理员编号
     */
    @TableField("user_code")
    private String userCode;

    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 密码盐
     */
    private String salt;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 状态(0:正常 1:冻结)
     */
    private String status;

    /**
     * 角色id
     */
    @TableField("role_id")
    private Long roleId;

    /**
     * 创建人id
     */
    @TableField("create_by")
    private Long createBy;

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


    public Long getUaid() {
		return uaid;
	}

	public void setUaid(Long uaid) {
		this.uaid = uaid;
	}

	public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
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
        return this.uaid;
    }

    @Override
    public String toString() {
        return "Admins{" +
        "aid=" + uaid +
        ", userCode=" + userCode +
        ", nickName=" + nickName +
        ", salt=" + salt +
        ", password=" + password +
        ", phone=" + phone +
        ", status=" + status +
        ", roleId=" + roleId +
        ", createBy=" + createBy +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
