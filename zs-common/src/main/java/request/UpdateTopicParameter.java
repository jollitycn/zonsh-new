package request;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;

/**
 * @author wangJin
 *
 * @date 2019年5月30日 下午4:34:30
 *
 */
public class UpdateTopicParameter implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private Long tid;
  @NotBlank(message="状态不能为空")
  private Integer status;

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
   * @return the status
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(final Integer status) {
    this.status = status;
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
    result = prime * result + ((status == null) ? 0 : status.hashCode());
    result = prime * result + ((tid == null) ? 0 : tid.hashCode());
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
    final UpdateTopicParameter other = (UpdateTopicParameter) obj;
    if (status == null) {
      if (other.status != null)
        return false;
    } else if (!status.equals(other.status))
      return false;
    if (tid == null) {
      if (other.tid != null)
        return false;
    } else if (!tid.equals(other.tid))
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
    return "UpdateTopicParameter [tid=" + tid + ", status=" + status + "]";
  }

}
