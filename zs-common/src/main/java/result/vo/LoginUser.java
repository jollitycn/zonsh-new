package result.vo;

import java.util.Date;


/**
* @author Xc
* @version 创建时间：2019年6月12日 下午3:59:48
* @ClassName 类名称
* @Description 类描述
*/
public class LoginUser {
	
    private Long uid;
    
    private String userNumber;

    private String phone;

    private String uname;

    private String wxName;
   
    private String headurl;

	/**
	 * 个人介绍（个人简介、签名）
	 */
    private String userSignature;
   
    private Integer gender;
    
    private Integer status;
   
    private Date createTime;
    
    private Date updataTime;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getWxName() {
		return wxName;
	}

	public void setWxName(String wxName) {
		this.wxName = wxName;
	}

	public String getHeadurl() {
		return headurl;
	}

	public void setHeadurl(String headurl) {
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

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdataTime() {
		return updataTime;
	}

	public void setUpdataTime(Date updataTime) {
		this.updataTime = updataTime;
	}

	@Override
	public String toString() {
		return "LoginUser{" +
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


