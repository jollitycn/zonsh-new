package result.vo;

import java.util.Date;
import java.util.List;

/**
 * @author wangJin
 *
 * @date 2019年5月30日 上午9:36:47
 *
 */
public class TopicHomePageResult extends TopicInviteResult {

  private static final long serialVersionUID = 1L;

  private Long tid;
  private String topicContent;// 话题内容
  private List<String> labelList;// 标签列表
  private String uname;// 创建人名称
  private Date publishTime;// 发布时间
  private String publishTimeStr;// 发布时间
  
  
  

  public String getPublishTimeStr() {
	return publishTimeStr;
}

public void setPublishTimeStr(String publishTimeStr) {
	this.publishTimeStr = publishTimeStr;
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
   * @return the labelList
   */
  public List<String> getLabelList() {
    return labelList;
  }

  /**
   * @param labelList the labelList to set
   */
  public void setLabelList(final List<String> labelList) {
    this.labelList = labelList;
  }

  /**
   * @return the uname
   */
  @Override
  public String getUname() {
    return uname;
  }

  /**
   * @param uname the uname to set
   */
  @Override
  public void setUname(final String uname) {
    this.uname = uname;
  }

  /**
   * @return the publishTime
   */
  public Date getPublishTime() {
    return publishTime;
  }

  /**
   * @param publishTime the publishTime to set
   */
  public void setPublishTime(final Date publishTime) {
    this.publishTime = publishTime;
  }

  /*
   * (non-Javadoc)
   *
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((labelList == null) ? 0 : labelList.hashCode());
    result =
        prime * result + ((publishTime == null) ? 0 : publishTime.hashCode());
    result = prime * result + ((tid == null) ? 0 : tid.hashCode());
    result =
        prime * result + ((topicContent == null) ? 0 : topicContent.hashCode());
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
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    final TopicHomePageResult other = (TopicHomePageResult) obj;
    if (labelList == null) {
      if (other.labelList != null)
        return false;
    } else if (!labelList.equals(other.labelList))
      return false;
    if (publishTime == null) {
      if (other.publishTime != null)
        return false;
    } else if (!publishTime.equals(other.publishTime))
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
    return "TopicHomePageResult [tid=" + tid + ", topicContent=" + topicContent
        + ", labelList=" + labelList + ", uname=" + uname + ", publishTime="
        + publishTime + "]";
  }



}
