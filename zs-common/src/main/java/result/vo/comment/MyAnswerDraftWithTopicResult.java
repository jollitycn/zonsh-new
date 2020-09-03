package result.vo.comment;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 我的草稿列表实体
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/24 11:22
 */
@Data
public class MyAnswerDraftWithTopicResult implements Serializable {
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
     * 创建时间
     */
    private Long createTime;
    /**
     * 回答的图片
     */
    private List<String> answerImageList;
    /**
     * 话题内容
     */
    private String topicContent;
}
