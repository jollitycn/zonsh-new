package user.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author xc
 * @since 2019-05-28
 */
@TableName("zs_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键ID
     */
    @TableId(value = "uid", type = IdType.AUTO)
    private Long uid;

    /**
     * 用户编号
     */
    @TableField("user_number")
    private String userNumber;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户名称
     */
    private String uname;

    /**
     * 微信名称
     */
    @TableField("wx_name")
    private String wxName;

    /**
     * 头像
     */
    private String headurl;

    /**
     * 个人介绍（个人说明、签名）
     */
    @TableField("user_signature")
    private String userSignature;

    /**
     * 性别 0男 1女 2未知
     */
    private Integer gender;

    /**
     * 0 新用户
     */
    private Integer status;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("updata_time")
    private Date updataTime;

    public Long getUid() {
        return uid;
    }

    public void setUid(final Long uid) {
        this.uid = uid;
    }


    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(final String userNumber) {
        this.userNumber = userNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(final String uname) {
        this.uname = uname;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(final String wxName) {
        this.wxName = wxName;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(final String headurl) {
        this.headurl = headurl;
    }

    public String getUserSignature() {
        return userSignature;
    }

    public void setUserSignature(String userSignature) {
        this.userSignature = userSignature;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(final Integer gender) {
        this.gender = gender;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(final Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(final Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdataTime() {
        return updataTime;
    }

    public void setUpdataTime(final Date updataTime) {
        this.updataTime = updataTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userNumber='" + userNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", uname='" + uname + '\'' +
                ", wxName='" + wxName + '\'' +
                ", headurl='" + headurl + '\'' +
                ", userSignature='" + userSignature + '\'' +
                ", gender=" + gender +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updataTime=" + updataTime +
                '}';
    }
}
