package result.vo.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/25 14:24
 */
 @Data
public class MyCollectionOfTopicResult implements Serializable {
    /**
     * 问题id
     */
    private Long tid;
    /**
     * 问题内容
     */
    private String topicContent;
    /**
     * 回答数
     */
    private Integer answerCount;
    /**
     * 话题图片
     */
    private List<String> imageList;
}
