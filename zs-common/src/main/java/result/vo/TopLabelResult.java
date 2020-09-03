package result.vo;

/**
 * @author wangJin
 *
 * @date 2019年5月29日 下午2:15:39
 *
 */
public class TopLabelResult {

  private Long tlid;//

  private String lname;// 标签名称

  private Integer topicCount;// 关联话题数

  /**
   * @return the tlid
   */
  public Long getTlid() {
    return tlid;
  }

  /**
   * @param tlid the tlid to set
   */
  public void setTlid(final Long tlid) {
    this.tlid = tlid;
  }

  /**
   * @return the lname
   */
  public String getLname() {
    return lname;
  }

  /**
   * @param lname the lname to set
   */
  public void setLname(final String lname) {
    this.lname = lname;
  }

  /**
   * @return the topicCount
   */
  public Integer getTopicCount() {
    return topicCount;
  }

  public void setTopicCount(final Integer topicCount) {
    this.topicCount = topicCount;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((lname == null) ? 0 : lname.hashCode());
    result = prime * result + ((tlid == null) ? 0 : tlid.hashCode());
    result =
        prime * result + ((topicCount == null) ? 0 : topicCount.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final TopLabelResult other = (TopLabelResult) obj;
    if (lname == null) {
      if (other.lname != null)
        return false;
    } else if (!lname.equals(other.lname))
      return false;
    if (tlid == null) {
      if (other.tlid != null)
        return false;
    } else if (!tlid.equals(other.tlid))
      return false;
    if (topicCount == null) {
      if (other.topicCount != null)
        return false;
    } else if (!topicCount.equals(other.topicCount))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "TopLabelResult [tlid=" + tlid + ", lname=" + lname + ", topicCount="
        + topicCount + "]";
  }



}
