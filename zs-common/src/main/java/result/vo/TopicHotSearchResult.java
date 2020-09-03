package result.vo;

/**
 * @author wangJin
 *
 * @date 2019年6月3日 下午5:21:40
 *
 */
public class TopicHotSearchResult {
  private Long uid;
  private Long tid;// 问题id
  private String topicContent;// 问题内容
  private String topicCreateTime;// 最新时间
  private Integer heatCount;// 热度
  private Integer replyCount;// 回答数



  /**
   * @return the uid
   */
  public Long getUid() {
    return uid;
  }

  /**
   * @param uid the uid to set
   */
  public void setUid(final Long uid) {
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
  public void setTid(final Long tid) {
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
  public void setTopicContent(final String topicContent) {
    this.topicContent = topicContent;
  }

  /**
   * @return the topicCreateTime
   */
  public String getTopicCreateTime() {
    return topicCreateTime;
  }

  /**
   * @param topicCreateTime the topicCreateTime to set
   */
  public void setTopicCreateTime(final String topicCreateTime) {
    this.topicCreateTime = topicCreateTime;
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
  public void setHeatCount(final Integer heatCount) {
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
  public void setReplyCount(final Integer replyCount) {
    this.replyCount = replyCount;
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
        prime * result + ((replyCount == null) ? 0 : replyCount.hashCode());
    result = prime * result + ((tid == null) ? 0 : tid.hashCode());
    result =
        prime * result + ((topicContent == null) ? 0 : topicContent.hashCode());
    result = prime * result
        + ((topicCreateTime == null) ? 0 : topicCreateTime.hashCode());
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
    final TopicHotSearchResult other = (TopicHotSearchResult) obj;
    if (heatCount == null) {
      if (other.heatCount != null)
        return false;
    } else if (!heatCount.equals(other.heatCount))
      return false;
    if (replyCount == null) {
      if (other.replyCount != null)
        return false;
    } else if (!replyCount.equals(other.replyCount))
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
    if (topicCreateTime == null) {
      if (other.topicCreateTime != null)
        return false;
    } else if (!topicCreateTime.equals(other.topicCreateTime))
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
    return "TopicHotSearchResult [tid=" + tid + ", topicContent=" + topicContent
        + ", topicCreateTime=" + topicCreateTime + ", heatCount=" + heatCount
        + ", replyCount=" + replyCount + "]";
  }



}
