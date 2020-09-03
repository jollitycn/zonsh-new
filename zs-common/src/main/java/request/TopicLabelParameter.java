package request;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotBlank;

/**
 * @author wangJin
 *
 * @date 2019年5月29日 下午2:02:16
 *
 */
public class TopicLabelParameter implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotBlank(message = "标签名称不能为空")
  private String lname;

  private Integer sort;// 排序

  private List<Long> list;

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
   * @return the sort
   */
  public Integer getSort() {
    return sort;
  }

  /**
   * @param sort the sort to set
   */
  public void setSort(final Integer sort) {
    this.sort = sort;
  }

  /**
   * @return the list
   */
  public List<Long> getList() {
    return list;
  }

  /**
   * @param list the list to set
   */
  public void setList(final List<Long> list) {
    this.list = list;
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
    result = prime * result + ((list == null) ? 0 : list.hashCode());
    result = prime * result + ((lname == null) ? 0 : lname.hashCode());
    result = prime * result + ((sort == null) ? 0 : sort.hashCode());
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
    final TopicLabelParameter other = (TopicLabelParameter) obj;
    if (list == null) {
      if (other.list != null)
        return false;
    } else if (!list.equals(other.list))
      return false;
    if (lname == null) {
      if (other.lname != null)
        return false;
    } else if (!lname.equals(other.lname))
      return false;
    if (sort == null) {
      if (other.sort != null)
        return false;
    } else if (!sort.equals(other.sort))
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
    return "TopicLabelParameter [lname=" + lname + ", sort=" + sort + ", list="
        + list + "]";
  }



}
