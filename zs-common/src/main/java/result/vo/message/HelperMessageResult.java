package result.vo.message;

import lombok.Data;

/**
 * 小助手
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/30 11:38
 */
@Data
public class HelperMessageResult {
    /**
     * 消息主键ID
     */
    private Long mid;
    /**
     * 消息标题
     */
    private String messageTitle;
    /**
     * 消息内容
     */
    private String messageContent;
    /**
     * 关联id
     */
    private Long relationId;
    /**
     * 是否已读 0未读 1已读
     */
    private Integer isView;
    /**
     * 创建时间
     */
    private Long createTime;
}
