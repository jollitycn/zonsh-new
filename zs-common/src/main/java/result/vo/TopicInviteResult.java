package result.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年5月29日 下午5:18:56
 *
 */
public class TopicInviteResult implements Serializable {
  private static final long serialVersionUID = 1L;
  private Long uid;
  private String uname;
  private Integer status;// 状态（1未被邀请）
  private Integer replyCount;// 回答总数
  private Integer inviteCount;// 邀请总数
  private Integer commentCount;// 评论总数
  private Integer totalViews;// 总观看数
  private String loginTime;// 登录时间

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
   * @return the uname
   */
  public String getUname() {
    return uname;
  }

  /**
   * @param uname the uname to set
   */
  public void setUname(final String uname) {
    this.uname = uname;
  }

  /**
   * @return the status
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * @param status the status to setdataType = "int"
   */
  public void setStatus(final Integer status) {
    this.status = status;
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

  /**
   * @return the inviteCount
   */
  public Integer getInviteCount() {
    return inviteCount;
  }

  /**
   * @param inviteCount the inviteCount to set
   */
  public void setInviteCount(final Integer inviteCount) {
    this.inviteCount = inviteCount;
  }

  /**
   * @return the commentCount
   */
  public Integer getCommentCount() {
    return commentCount;
  }

  /**
   * @param commentCount the commentCount to set
   */
  public void setCommentCount(final Integer commentCount) {
    this.commentCount = commentCount;
  }

  /**
   * @return the totalViews
   */
  public Integer getTotalViews() {
    return totalViews;
  }

  /**
   * @param totalViews the totalViews to set
   */
  public void setTotalViews(final Integer totalViews) {
    this.totalViews = totalViews;
  }

  /**
   * @return the loginTime
   */
  public String getLoginTime() {
    return loginTime;
  }

  /**
   * @param loginTime the loginTime to set
   */
  public void setLoginTime(final String loginTime) {
    this.loginTime = loginTime;
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
    result =
        prime * result + ((commentCount == null) ? 0 : commentCount.hashCode());
    result =
        prime * result + ((inviteCount == null) ? 0 : inviteCount.hashCode());
    result = prime * result + ((loginTime == null) ? 0 : loginTime.hashCode());
    result =
        prime * result + ((replyCount == null) ? 0 : replyCount.hashCode());
    result = prime * result + ((status == null) ? 0 : status.hashCode());
    result =
        prime * result + ((totalViews == null) ? 0 : totalViews.hashCode());
    result = prime * result + ((uid == null) ? 0 : uid.hashCode());
    result = prime * result + ((uname == null) ? 0 : uname.hashCode());
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
    final TopicInviteResult other = (TopicInviteResult) obj;
    if (commentCount == null) {
      if (other.commentCount != null)
        return false;
    } else if (!commentCount.equals(other.commentCount))
      return false;
    if (inviteCount == null) {
      if (other.inviteCount != null)
        return false;
    } else if (!inviteCount.equals(other.inviteCount))
      return false;
    if (loginTime == null) {
      if (other.loginTime != null)
        return false;
    } else if (!loginTime.equals(other.loginTime))
      return false;
    if (replyCount == null) {
      if (other.replyCount != null)
        return false;
    } else if (!replyCount.equals(other.replyCount))
      return false;
    if (status == null) {
      if (other.status != null)
        return false;
    } else if (!status.equals(other.status))
      return false;
    if (totalViews == null) {
      if (other.totalViews != null)
        return false;
    } else if (!totalViews.equals(other.totalViews))
      return false;
    if (uid == null) {
      if (other.uid != null)
        return false;
    } else if (!uid.equals(other.uid))
      return false;
    if (uname == null) {
      if (other.uname != null)
        return false;
    } else if (!uname.equals(other.uname))
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
    return "TopicInviteResult [uid=" + uid + ", uname=" + uname + ", status="
        + status + ", replyCount=" + replyCount + ", inviteCount=" + inviteCount
        + ", commentCount=" + commentCount + ", totalViews=" + totalViews
        + ", loginTime=" + loginTime + "]";
  }



}
