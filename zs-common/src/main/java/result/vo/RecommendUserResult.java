package result.vo;
/**
* @author Xc
* @version 创建时间：2019年6月26日 上午11:01:47
* @ClassName 类名称
* @Description 类描述
*/
public class RecommendUserResult {

	private Long uid;

	private String headUrl; //头像url
	
	private String uname; //昵称
	
	private Integer gender; //性别 0未知 1男 2女
	
	private String  introduce;//个人简介
	
	private String  answerCount;//回答数量
	
	private int isInvitation;//是否已邀请 0 否 1是
	
	public String getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(String answerCount) {
		this.answerCount = answerCount;
	}

	public int getIsInvitation() {
		return isInvitation;
	}

	public void setIsInvitation(int isInvitation) {
		this.isInvitation = isInvitation;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
}


