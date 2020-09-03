package user.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import request.PageParam;
import request.user.RpcBulletinMessageParameter;
import result.vo.message.*;
import user.entity.Message;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xc
 * @since 2019-06-28
 */
public interface IMessageService extends IService<Message> {

    /**
     * 获取用户消息类型
     *
     * @param uid
     * @return
     */
    List<MessageTypeResult> getMessageType(Long uid);


    /**
     * 获取指定类型的消息列表
     *
     * @param uid
     * @param type
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<MessageResult> getMessageList(Long uid, Integer type, Integer pageNum, Integer pageSize);


    /**
     * 删除指定类型所有消息
     *
     * @param uid
     * @param type
     * @return
     */
    Boolean delMessage(Long uid, Integer type);


    /**
     * 将指定类型关联的消息全部置为已读
     *
     * @param uid
     * @param relationId
     */
    Boolean readMessage(Long uid, Long relationId, Integer type);

    /**
     * 新增
     *
     * @param param
     * @return
     */
    Boolean addMessage(RpcBulletinMessageParameter param);

    Boolean deleteBulletinMessage(Long bnid, Long type);

    /**
     * 分页获取当前登录用户的互动消息
     *
     * @param pageParam 分页参数
     * @param loginUid  登录用户uid
     * @return com.baomidou.mybatisplus.plugins.Page&lt;result.vo.message.InteractiveMessageResult&gt;
     * @author Pan Juncai
     * @date 2019/7/29 17:10
     */
    Page<InteractiveMessageResult> listInteractivePage(PageParam pageParam, Long loginUid);

    /**
     * 分页获取当前登录用户的关注消息
     *
     * @param pageParam 分页参数
     * @param loginUid  登录用户uid
     * @return com.baomidou.mybatisplus.plugins.Page&lt;result.vo.message.FollowMessageResult&gt;
     * @author Pan Juncai
     * @date 2019/7/30 9:53
     */
    Page<FollowMessageResult> listFollowPage(PageParam pageParam, Long loginUid);

    /**
     * 根据用户uid分页获取该用户的小助手消息列表
     *
     * @param pageParam 分页信息
     * @param loginUid  登录用户uid
     * @return com.baomidou.mybatisplus.plugins.Page&lt;result.vo.message.HelperMessageResult&gt;
     * @author Pan Juncai
     * @date 2019/7/30 14:07
     */
    Page<HelperMessageResult> listHelperPage(PageParam pageParam, Long loginUid);

}
