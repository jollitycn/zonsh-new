package result.vo.comment;


import lombok.Data;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/2 18:22
 */
 @Data
public class CommentReplyResult {
    /**
     * 主键id
     */
    private Long cid;

    /**
     * 被回复的评论id
     */
    private Long parentCid;

    /**
     * 被回复用户id，即上一级回复的uid
     */
    private Long repliedUid;

    /**
     * 被评论用户名称
     */
    private String repliedUname;

    /**
     * 内容
     */
    private String commentContent;

    /**
     * 点赞数
     */
    private Long likeCount;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 本条回复的用户uid
     */
    private Long uid;

    /**
     * 本条评论用户名称
     */
    private String createUname;

    /**
     * 头像地址
     */
    private String headUrl;

    /**
     * 用户签名
     */
    private String userSignature;

    /**
     * 状态：0---已删除  1---使用中  2---屏蔽
     */
    private Integer status;
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
}
