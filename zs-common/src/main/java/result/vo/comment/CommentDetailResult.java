package result.vo.comment;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/3 19:11
 */
public class CommentDetailResult {
    /**
     * 评论人名字
     */
    private String commentUname;

    /**
     * 评论人头像
     */
    private String commentHeadUrl;
    /**
     * 被回复人
     */
    private String repliedUname;
    /**
     * 评论内容
     */
    private String commentContent;

    public String getCommentUname() {
        return commentUname;
    }

    public void setCommentUname(String commentUname) {
        this.commentUname = commentUname;
    }

    public String getCommentHeadUrl() {
        return commentHeadUrl;
    }

    public void setCommentHeadUrl(String commentHeadUrl) {
        this.commentHeadUrl = commentHeadUrl;
    }

    public String getRepliedUname() {
        return repliedUname;
    }

    public void setRepliedUname(String repliedUname) {
        this.repliedUname = repliedUname;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    @Override
    public String toString() {
        return "CommentDetailResult{" +
                "commentUname='" + commentUname + '\'' +
                ", commentHeadUrl='" + commentHeadUrl + '\'' +
                ", repliedUname='" + repliedUname + '\'' +
                ", commentContent='" + commentContent + '\'' +
                '}';
    }
}
