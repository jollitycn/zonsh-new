package result.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangJin
 *
 * @date 2019年5月31日 上午10:06:37
 *
 */
@ApiModel(value = "app首页返回")
public class TopicHomeReplyAppResult implements Serializable {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "用户id", name = "uid", example = "1")
  private Long uid;

  private String uname;// 用户名称
  private String headUrl;// 用户头像
  private String rankName;// 等级名称
  private List<String> replyImg;// 回答图片列表
  private String replyContent;// 回答内容


  @ApiModelProperty(value = "评论", name = "reviewCount", example = "1")
  private Integer reviewCount;
  private Integer likeCount;

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
   * @return the uname
   */
  public String getUname() {
    return uname;
  }

  /**
   * @param uname the uname to set
   */
  public void setUname(String uname) {
    this.uname = uname;
  }

  /**
   * @return the headUrl
   */
  public String getHeadUrl() {
    return headUrl;
  }

  /**
   * @param headUrl the headUrl to set
   */
  public void setHeadUrl(String headUrl) {
    this.headUrl = headUrl;
  }

  /**
   * @return the rankName
   */
  public String getRankName() {
    return rankName;
  }

  /**
   * @param rankName the rankName to set
   */
  public void setRankName(String rankName) {
    this.rankName = rankName;
  }

 

  public List<String> getReplyImg() {
	return replyImg;
}
  

public void setReplyImg(List<String> replyImg) {
	this.replyImg = replyImg;
}

/**
   * @return the replyContent
   */
  public String getReplyContent() {
    return replyContent;
  }

  /**
   * @param replyContent the replyContent to set
   */
  public void setReplyContent(String replyContent) {
    this.replyContent = replyContent;
  }

  /**
   * @return the reviewCount
   */
  public Integer getReviewCount() {
    return reviewCount;
  }

  /**
   * @param reviewCount the reviewCount to set
   */
  public void setReviewCount(Integer reviewCount) {
    this.reviewCount = reviewCount;
  }

  /**
   * @return the likeCount
   */
  public Integer getLikeCount() {
    return likeCount;
  }

  /**
   * @param likeCount the likeCount to set
   */
  public void setLikeCount(Integer likeCount) {
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
    result = prime * result + ((headUrl == null) ? 0 : headUrl.hashCode());
    result = prime * result + ((likeCount == null) ? 0 : likeCount.hashCode());
    result = prime * result + ((rankName == null) ? 0 : rankName.hashCode());
    result =
        prime * result + ((replyContent == null) ? 0 : replyContent.hashCode());
    result = prime * result + ((replyImg == null) ? 0 : replyImg.hashCode());
    result =
        prime * result + ((reviewCount == null) ? 0 : reviewCount.hashCode());
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
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TopicHomeReplyAppResult other = (TopicHomeReplyAppResult) obj;
    if (headUrl == null) {
      if (other.headUrl != null)
        return false;
    } else if (!headUrl.equals(other.headUrl))
      return false;
    if (likeCount == null) {
      if (other.likeCount != null)
        return false;
    } else if (!likeCount.equals(other.likeCount))
      return false;
    if (rankName == null) {
      if (other.rankName != null)
        return false;
    } else if (!rankName.equals(other.rankName))
      return false;
    if (replyContent == null) {
      if (other.replyContent != null)
        return false;
    } else if (!replyContent.equals(other.replyContent))
      return false;
    if (replyImg == null) {
      if (other.replyImg != null)
        return false;
    } else if (!replyImg.equals(other.replyImg))
      return false;
    if (reviewCount == null) {
      if (other.reviewCount != null)
        return false;
    } else if (!reviewCount.equals(other.reviewCount))
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
    return "TopicHomeReplyAppResult [uid=" + uid + ", uname=" + uname
        + ", headUrl=" + headUrl + ", rankName=" + rankName + ", replyImg="
        + replyImg + ", replyContent=" + replyContent + ", reviewCount="
        + reviewCount + ", likeCount=" + likeCount + "]";
  }



}
