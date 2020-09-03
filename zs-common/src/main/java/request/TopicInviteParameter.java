package request;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年5月29日 上午11:27:29
 *
 */
public class TopicInviteParameter implements Serializable{

  private static final long serialVersionUID = 1L;
  private Long uid;//用户表id
  private Integer type;//1系统邀请  2用户邀请
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
   * @return the type
   */
  public Integer getType() {
    return type;
  }
  /**
   * @param type the type to set
   */
  public void setType(final Integer type) {
    this.type = type;
  }
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((type == null) ? 0 : type.hashCode());
    result = prime * result + ((uid == null) ? 0 : uid.hashCode());
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
    final TopicInviteParameter other = (TopicInviteParameter) obj;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    if (uid == null) {
      if (other.uid != null)
        return false;
    } else if (!uid.equals(other.uid))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "TopicInviteParameter [uid=" + uid + ", type=" + type + "]";
  }


}
