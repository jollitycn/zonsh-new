package result.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wangJin
 *
 * @date 2019年6月10日 下午4:27:55
 *
 */
public class TopicReplyResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long tid;
	private Long aid;
	private Long uid;
	private String answerTitle;// 回答概述
	private String answerContent;// 回答内容
	private String topic;// 来源（话题内容）
	private String uName;// 用户名称
	private String publishTime;// 发布时间
	private Integer readCount;// 阅读数
	private Integer commentCount;// 评论数
	private Integer likeCount;// 点赞数

	public String getAnswerTitle() {
		return answerTitle;
	}

	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	/**
	 * @return the tid
	 */
	public Long getTid() {
		return tid;
	}

	/**
	 * @param tid
	 *            the tid to set
	 */
	public void setTid(final Long tid) {
		this.tid = tid;
	}

	/**
	 * @return the aid
	 */
	public Long getAid() {
		return aid;
	}

	/**
	 * @param aid
	 *            the aid to set
	 */
	public void setAid(final Long aid) {
		this.aid = aid;
	}

	/**
	 * @return the uid
	 */
	public Long getUid() {
		return uid;
	}

	/**
	 * @param uid
	 *            the uid to set
	 */
	public void setUid(final Long uid) {
		this.uid = uid;
	}

	/**
	 * @return the replySummary
	 */
	public String getReplySummary() {
		return answerContent;
	}

	/**
	 * @param replySummary
	 *            the replySummary to set
	 */
	public void setReplySummary(final String replySummary) {
		this.answerContent = replySummary;
	}

	/**
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * @param topic
	 *            the topic to set
	 */
	public void setTopic(final String topic) {
		this.topic = topic;
	}

	/**
	 * @return the uName
	 */
	public String getuName() {
		return uName;
	}

	/**
	 * @param uName
	 *            the uName to set
	 */
	public void setuName(final String uName) {
		this.uName = uName;
	}

	/**
	 * @return the publishTime
	 */
	public String getPublishTime() {
		return publishTime;
	}

	/**
	 * @param publishTime
	 *            the publishTime to set
	 */
	public void setPublishTime(final Date publishTime) {
		this.publishTime = publishTime.getTime() + "";
	}

	/**
	 * @return the readCount
	 */
	public Integer getReadCount() {
		return readCount;
	}

	/**
	 * @param readCount
	 *            the readCount to set
	 */
	public void setReadCount(final Integer readCount) {
		this.readCount = readCount;
	}

	/**
	 * @return the commentCount
	 */
	public Integer getCommentCount() {
		return commentCount;
	}

	/**
	 * @param commentCount
	 *            the commentCount to set
	 */
	public void setCommentCount(final Integer commentCount) {
		this.commentCount = commentCount;
	}

	/**
	 * @return the likeCount
	 */
	public Integer getLikeCount() {
		return likeCount;
	}

	/**
	 * @param likeCount
	 *            the likeCount to set
	 */
	public void setLikeCount(final Integer likeCount) {
		this.likeCount = likeCount;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aid == null) ? 0 : aid.hashCode());
		result = prime * result + ((commentCount == null) ? 0 : commentCount.hashCode());
		result = prime * result + ((likeCount == null) ? 0 : likeCount.hashCode());
		result = prime * result + ((publishTime == null) ? 0 : publishTime.hashCode());
		result = prime * result + ((readCount == null) ? 0 : readCount.hashCode());
		result = prime * result + ((answerContent == null) ? 0 : answerContent.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
		result = prime * result + ((topic == null) ? 0 : topic.hashCode());
		result = prime * result + ((uName == null) ? 0 : uName.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final TopicReplyResult other = (TopicReplyResult) obj;
		if (aid == null) {
			if (other.aid != null)
				return false;
		} else if (!aid.equals(other.aid))
			return false;
		if (commentCount == null) {
			if (other.commentCount != null)
				return false;
		} else if (!commentCount.equals(other.commentCount))
			return false;
		if (likeCount == null) {
			if (other.likeCount != null)
				return false;
		} else if (!likeCount.equals(other.likeCount))
			return false;
		if (publishTime == null) {
			if (other.publishTime != null)
				return false;
		} else if (!publishTime.equals(other.publishTime))
			return false;
		if (readCount == null) {
			if (other.readCount != null)
				return false;
		} else if (!readCount.equals(other.readCount))
			return false;
		if (answerContent == null) {
			if (other.answerContent != null)
				return false;
		} else if (!answerContent.equals(other.answerContent))
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		if (topic == null) {
			if (other.topic != null)
				return false;
		} else if (!topic.equals(other.topic))
			return false;
		if (uName == null) {
			if (other.uName != null)
				return false;
		} else if (!uName.equals(other.uName))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TopicReplyResult [tid=" + tid + ", aid=" + aid + ", uid=" + uid + ", replySummary=" + answerContent
				+ ", topic=" + topic + ", uName=" + uName + ", publishTime=" + publishTime + ", readCount=" + readCount
				+ ", commentCount=" + commentCount + ", likeCount=" + likeCount + "]";
	}

}
