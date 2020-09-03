package request.user;

import lombok.Data;

@Data
public class RpcBulletinMessageParameter {
    /**
     * 类型  1小助手 2回答邀请 3互动  4关注 5意见反馈
     */
    private Integer type;
    /**
     * 接收用户id，为空表示默认发给所有人
     */
    private Long fromUid;
    /**
     * 关联id 可能包含用户id 话题id 活动id 评论id 公告id 反馈id，具体根据type判断
     */
    private Long relationId;
    /**
     * 消息标题
     */
    private String messageTitle;
    /**
     * 消息内容
     */
    private String messageContent;
    /**
     * 创建用户id 可能包含系统用户
     */
    private Long createUid;
    /**
     * 创建用户类型 0用户 1官方管理员
     */
    private Integer createUidType;
}
