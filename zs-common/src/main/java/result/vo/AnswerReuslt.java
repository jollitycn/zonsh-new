package result.vo;

import java.util.List;
import java.util.Objects;

/**
 * @author Xc
 * @version 创建时间：2019年6月13日 下午1:37:09
 * @ClassName 类名称
 * @Description 类描述
 */
public class AnswerReuslt {

    private Long aid;

    private Long uid;

    private Integer status;

    private String uname;

    private String userLabel;

    private String headurl;

    private String answerTitle;

    private String content;

    private Integer likeCount;

    private Integer commentCount;

    private Long releaseTime;

    private List<String> urlList;

    /**
     * 点赞标识
     */
    private Integer isLike;
    /**
     * 收藏标识
     */
    private Integer isCollection;
    /**
     * 举报标识
     */
    private Integer isReport;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAnswerTitle() {
        return answerTitle;
    }

    public void setAnswerTitle(String answerTitle) {
        this.answerTitle = answerTitle;
    }

    public Long getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Long releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(String userLabel) {
        this.userLabel = userLabel;
    }

    public String getHeadurl() {
        return headurl;
    }

    public void setHeadurl(String headurl) {
        this.headurl = headurl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public void setUrlList(List<String> urlList) {
        this.urlList = urlList;
    }

    public Integer getIsLike() {
        return isLike;
    }

    public void setIsLike(Integer isLike) {
        this.isLike = isLike;
    }

    public Integer getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(Integer isCollection) {
        this.isCollection = isCollection;
    }

    public Integer getIsReport() {
        return isReport;
    }

    public void setIsReport(Integer isReport) {
        this.isReport = isReport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnswerReuslt that = (AnswerReuslt) o;
        return Objects.equals(getAid(), that.getAid()) &&
                Objects.equals(getUid(), that.getUid()) &&
                Objects.equals(getStatus(), that.getStatus()) &&
                Objects.equals(getUname(), that.getUname()) &&
                Objects.equals(getUserLabel(), that.getUserLabel()) &&
                Objects.equals(getHeadurl(), that.getHeadurl()) &&
                Objects.equals(getAnswerTitle(), that.getAnswerTitle()) &&
                Objects.equals(getContent(), that.getContent()) &&
                Objects.equals(getLikeCount(), that.getLikeCount()) &&
                Objects.equals(getCommentCount(), that.getCommentCount()) &&
                Objects.equals(getReleaseTime(), that.getReleaseTime()) &&
                Objects.equals(getUrlList(), that.getUrlList()) &&
                Objects.equals(getIsLike(), that.getIsLike()) &&
                Objects.equals(getIsCollection(), that.getIsCollection()) &&
                Objects.equals(getIsReport(), that.getIsReport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAid(), getUid(), getStatus(), getUname(), getUserLabel(), getHeadurl(),
                getAnswerTitle(), getContent(), getLikeCount(), getCommentCount(), getReleaseTime(), getUrlList(),
                getIsLike(), getIsCollection(), getIsReport());
    }

    @Override
    public String toString() {
        return "AnswerReuslt{" +
                "aid=" + aid +
                ", uid=" + uid +
                ", status=" + status +
                ", uname='" + uname + '\'' +
                ", userLabel='" + userLabel + '\'' +
                ", headurl='" + headurl + '\'' +
                ", answerTitle='" + answerTitle + '\'' +
                ", content='" + content + '\'' +
                ", likeCount=" + likeCount +
                ", commentCount=" + commentCount +
                ", releaseTime=" + releaseTime +
                ", urlList=" + urlList +
                ", isLike=" + isLike +
                ", isCollection=" + isCollection +
                ", isReport=" + isReport +
                '}';
    }
}


