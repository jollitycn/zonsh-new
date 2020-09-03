package request;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年6月12日 下午2:35:09
 *
 */
public class RpcAnswerParameter implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private Long tid;
  private Integer pageNum;
  private Integer pageSize;
  private String searchKey;
  private String content;


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
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * @return the pageNum
   */
  public Integer getPageNum() {
    return pageNum;
  }

  /**
   * @param pageNum the pageNum to set
   */
  public void setPageNum(final Integer pageNum) {
    this.pageNum = pageNum;
  }

  /**
   * @return the pageSize
   */
  public Integer getPageSize() {
    return pageSize;
  }

  /**
   * @param pageSize the pageSize to set
   */
  public void setPageSize(final Integer pageSize) {
    this.pageSize = pageSize;
  }

  /**
   * @return the searchKey
   */
  public String getSearchKey() {
    return searchKey;
  }

  /**
   * @param searchKey the searchKey to set
   */
  public void setSearchKey(final String searchKey) {
    this.searchKey = searchKey;
  }

  /**
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * @param content the content to set
   */
  public void setContent(final String content) {
    this.content = content;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((content == null) ? 0 : content.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((pageNum == null) ? 0 : pageNum.hashCode());
    result = prime * result + ((pageSize == null) ? 0 : pageSize.hashCode());
    result = prime * result + ((searchKey == null) ? 0 : searchKey.hashCode());
    result = prime * result + ((tid == null) ? 0 : tid.hashCode());
    return result;
  }

  /* (non-Javadoc)
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
    RpcAnswerParameter other = (RpcAnswerParameter) obj;
    if (content == null) {
      if (other.content != null)
        return false;
    } else if (!content.equals(other.content))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (pageNum == null) {
      if (other.pageNum != null)
        return false;
    } else if (!pageNum.equals(other.pageNum))
      return false;
    if (pageSize == null) {
      if (other.pageSize != null)
        return false;
    } else if (!pageSize.equals(other.pageSize))
      return false;
    if (searchKey == null) {
      if (other.searchKey != null)
        return false;
    } else if (!searchKey.equals(other.searchKey))
      return false;
    if (tid == null) {
      if (other.tid != null)
        return false;
    } else if (!tid.equals(other.tid))
      return false;
    return true;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "RpcAnswerParameter [id=" + id + ", tid=" + tid + ", pageNum="
        + pageNum + ", pageSize=" + pageSize + ", searchKey=" + searchKey
        + ", content=" + content + "]";
  }



}
