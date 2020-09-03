package result.vo;

import java.io.Serializable;

/**
 * @author wangJin
 *
 * @date 2019年5月29日 下午4:40:17
 *
 */
public class UploadResult implements Serializable{


  private static final long serialVersionUID = 1L;
  private String url;
  private String fileSize;//文件大小
  /**
   * @return the url
   */
  public String getUrl() {
    return url;
  }
  /**
   * @param url the url to set
   */
  public void setUrl(final String url) {
    this.url = url;
  }
  /**
   * @return the fileSize
   */
  public String getFileSize() {
    return fileSize;
  }
  /**
   * @param fileSize the fileSize to set
   */
  public void setFileSize(final String fileSize) {
    this.fileSize = fileSize;
  }
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
    result = prime * result + ((url == null) ? 0 : url.hashCode());
    return result;
  }
  /* (non-Javadoc)
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
    final UploadResult other = (UploadResult) obj;
    if (fileSize == null) {
      if (other.fileSize != null)
        return false;
    } else if (!fileSize.equals(other.fileSize))
      return false;
    if (url == null) {
      if (other.url != null)
        return false;
    } else if (!url.equals(other.url))
      return false;
    return true;
  }
  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "UploadResult [url=" + url + ", fileSize=" + fileSize + "]";
  }


}
