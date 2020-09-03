package result.vo.comment;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/25 13:31
 */
@Data
public class MyCollectionOfAnswerResult implements Serializable {
    /**
     * 回答id
     */
    private Long aid;
    /**
     * 话题id
     */
    private Long tid;
    /**
     * 回答标题
     */
    private String answerTitle;
    /**
     * 回答内容
     */
    private String answerContent;
    /**
     * 评论数
     */
    private Integer commentCount;
    /**
     * 点赞数
     */
    private Integer likeCount;
    /**
     * 回答时间（发布时间）
     */
    private Long releaseTime;
    /**
     * 回答用户uid
     */
    private Long answerUid;
    /**
     * 回答用户名（昵称）
     */
    private String uname;
    /**
     * 回答用户头像地址
     */
    private String headUrl;
    /**
     * 回答用户简介（签名）
     */
    private String userSignature;
    /**
     * 关注状态：0 未关注  1 已关注  2 互相关注
     */
    private Integer followStatus;
    /**
     * 收藏时间
     */
    private Long collectionTime;
    /**
     * 话题内容
     */
    private String topicContent;
    /**
     * 回答的图片
     */
    private List<String> answerImageList;
}
