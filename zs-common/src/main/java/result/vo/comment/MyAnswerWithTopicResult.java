package result.vo.comment;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 我的---我的回答列表返回实体
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/23 13:59
 */
@Data
public class MyAnswerWithTopicResult implements Serializable {
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
     * 状态 0正常 2屏蔽
     */
    private Integer status;
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
     * 话题内容
     */
    private String topicContent;
    /**
     * 回答的图片
     */
    private List<String> answerImageList;
}
