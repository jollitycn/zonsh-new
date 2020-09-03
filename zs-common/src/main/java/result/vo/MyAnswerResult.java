package result.vo;

import java.util.Date;

public class MyAnswerResult {
	
	private Long aid;

	private Long uid;
	
	private String answerContent;
	
	private Integer status;
	
	private Long releaseTime;

	public Long getAid() {
		return aid;
	}

	public void setAid(Long aid) {
		this.aid = aid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getAnswerTontent() {
		return answerContent;
	}

	public void setAnswerTontent(String answerContent) {
		this.answerContent = answerContent;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Long releaseTime) {
		this.releaseTime = releaseTime;
	}
	
	
	

}
