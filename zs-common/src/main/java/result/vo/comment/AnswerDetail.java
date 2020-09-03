package result.vo.comment;


import lombok.Data;

/**
 * @author wangJin
 * @date 2019年6月13日 上午10:06:49
 */
@Data
public class AnswerDetail {
    /**
     * 回答id
     */
    private Long aid;
    /**
     * 话题id
     */
    private Long tid;
    /**
     * 用户id
     */
    private Long uid;
    /**
     * 回答编号
     */
    private String answerNumber;
    /**
     * 回答标题
     */
    private String answerTitle;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 回答数
     */
    private Integer answerCount;
    /**
     * 评论数
     */
    private Integer commentCount;
    /**
     * 评论时间
     */
    private Long commentTime;
    /**
     * 点赞数
     */
    private Integer likeCount;
    /**
     * 回答内容
     */
    private String answerContent;
    /**
     * 户头像用
     */
    private String headUrl;
    /**
     * 用户昵称
     */
    private String uname;
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
