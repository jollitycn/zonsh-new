package result.vo.comment;

import lombok.Data;
import result.vo.UserResult;

import java.util.List;

/**
 * 一级评论返回值，包含用户信息
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/2 18:17
 */
 @Data
public class LevelOneCommentResult {
    /**
     * 主键id
     */
    private Long cid;
    /**
     * 回答/活动id
     */
    private Long aid;
    /**
     * 评论用户id
     */
    private Long uid;
    /**
     * 评论内容
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
    /**
     * 用户信息
     */
    private UserResult user;
    /**
     * 回复集合
     */
    private List<CommentReplyResult> replyList;
}
