package result.vo;

import java.io.Serializable;
import java.util.List;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangJin
 *
 * @date 2019年6月3日 下午2:44:23
 *
 */
public class TopicResult implements Serializable {


  private static final long serialVersionUID = 1L;

  private Long uid;
  private Long tid;// 问题id
  private String topicContent;// 问题内容
  private Integer isAnswer;// 是否回答过 1回答过  0否 2有草稿
  private Integer inviteCount;// 邀请数
  private Integer heatCount;// 热度
  private Integer replyCount;// 回答数

  private List<String> urlList;// 话题图片
  private List<AnswerReuslt> replyList;// 回答列表
  
  

  public Integer getIsAnswer() {
	return isAnswer;
}

public void setIsAnswer(Integer isAnswer) {
	this.isAnswer = isAnswer;
}

/**
   * @return the uid
   */
  public Long getUid() {
    return uid;
  }

  /**
   * @param uid the uid to set
   */
  public void setUid(Long uid) {
    this.uid = uid;
  }

  /**
   * @return the tid
   */
  public Long getTid() {
    return tid;
  }

  /**
   * @param tid the tid to set
   */
  public void setTid(Long tid) {
    this.tid = tid;
  }

  /**
   * @return the topicContent
   */
  public String getTopicContent() {
    return topicContent;
  }

  /**
   * @param topicContent the topicContent to set
   */
  public void setTopicContent(String topicContent) {
    this.topicContent = topicContent;
  }

  /**
   * @return the inviteCount
   */
  public Integer getInviteCount() {
    return inviteCount;
  }

  /**
   * @param inviteCount the inviteCount to set
   */
  public void setInviteCount(Integer inviteCount) {
    this.inviteCount = inviteCount;
  }

  /**
   * @return the heatCount
   */
  public Integer getHeatCount() {
    return heatCount;
  }

  /**
   * @param heatCount the heatCount to set
   */
  public void setHeatCount(Integer heatCount) {
    this.heatCount = heatCount;
  }

  /**
   * @return the replyCount
   */
  public Integer getReplyCount() {
    return replyCount;
  }

  /**
   * @param replyCount the replyCount to set
   */
  public void setReplyCount(Integer replyCount) {
    this.replyCount = replyCount;
  }

  /**
   * @return the urlList
   */
  public List<String> getUrlList() {
    return urlList;
  }

  /**
   * @param urlList the urlList to set
   */
  public void setUrlList(List<String> urlList) {
    this.urlList = urlList;
  }

  /**
   * @return the replyList
   */
  public List<AnswerReuslt> getReplyList() {
    return replyList;
  }

  /**
   * @param replyList the replyList to set
   */
  public void setReplyList(List<AnswerReuslt> replyList) {
    this.replyList = replyList;
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
    result = prime * result + ((heatCount == null) ? 0 : heatCount.hashCode());
    result =
        prime * result + ((inviteCount == null) ? 0 : inviteCount.hashCode());
    result =
        prime * result + ((replyCount == null) ? 0 : replyCount.hashCode());
    result = prime * result + ((replyList == null) ? 0 : replyList.hashCode());
    result = prime * result + ((tid == null) ? 0 : tid.hashCode());
    result =
        prime * result + ((topicContent == null) ? 0 : topicContent.hashCode());
    result = prime * result + ((uid == null) ? 0 : uid.hashCode());
    result = prime * result + ((urlList == null) ? 0 : urlList.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TopicResult other = (TopicResult) obj;
    if (heatCount == null) {
      if (other.heatCount != null)
        return false;
    } else if (!heatCount.equals(other.heatCount))
      return false;
    if (inviteCount == null) {
      if (other.inviteCount != null)
        return false;
    } else if (!inviteCount.equals(other.inviteCount))
      return false;
    if (replyCount == null) {
      if (other.replyCount != null)
        return false;
    } else if (!replyCount.equals(other.replyCount))
      return false;
    if (replyList == null) {
      if (other.replyList != null)
        return false;
    } else if (!replyList.equals(other.replyList))
      return false;
    if (tid == null) {
      if (other.tid != null)
        return false;
    } else if (!tid.equals(other.tid))
      return false;
    if (topicContent == null) {
      if (other.topicContent != null)
        return false;
    } else if (!topicContent.equals(other.topicContent))
      return false;
    if (uid == null) {
      if (other.uid != null)
        return false;
    } else if (!uid.equals(other.uid))
      return false;
    if (urlList == null) {
      if (other.urlList != null)
        return false;
    } else if (!urlList.equals(other.urlList))
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
    return "TopicResult [uid=" + uid + ", tid=" + tid + ", topicContent="
        + topicContent + ", inviteCount=" + inviteCount + ", heatCount="
        + heatCount + ", replyCount=" + replyCount + ", urlList=" + urlList
        + ", replyList=" + replyList + "]";
  }



}
