package result.vo.message;

import lombok.Data;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/30 9:52
 */
 @Data
public class FollowMessageResult {
    /**
     * 消息主键ID
     */
    private Long mid;
    /**
     * 用户uid
     */
    private Long uid;
    /**
     * 用户头像地址
     */
    private String headUrl;
    /**
     * 用户名称（昵称）
     */
    private String uname;
    /**
     *
     */
    private Integer followStatus;
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
