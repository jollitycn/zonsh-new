package result.vo.message;

import lombok.Data;

/**
 * 互动通知返回结果
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/29 17:02
 */
@Data
public class InteractiveMessageResult {
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
     * 评论对应的问题tid（为了跳转到回答详情）
     */
    private Long tid;
    /**
     * 评论对应的回答aid（为了跳转到回答详情）
     */
    private Long aid;
    /**
     * 评论状态： 0---已删除  1---正常
     */
    private Integer commentStatus;
    /**
     * 是否已读 0未读 1已读
     */
    private Integer isView;
    /**
     * 创建时间
     */
    private Long createTime;
}
