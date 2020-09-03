package user.mapper;

import request.PageParam;
import result.vo.message.*;
import user.entity.Message;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xc
 * @since 2019-06-28
 */
public interface MessageMapper extends BaseMapper<Message> {

    List<MessageTypeResult> getMessageType(@Param("uid") Long uid);

    List<MessageResult> getMessageList(Page<MessageResult> page, @Param("uid") Long uid);

    MessageTypeResult getAssistantMessage();

    MessageTypeResult getInvitationMessage(@Param("uid") Long uid);

    List<String> getInvitationMessageCount(@Param("uid") Long uid, @Param("tid") Long tid);

    MessageTypeResult getfollowMessage(@Param("uid") Long uid);

    MessageTypeResult getCommentMessage(@Param("uid") Long uid);

    /**
     * 根据用户uid分页获取该用户的互动消息
     *
     * @param pageParam 分页参数
     * @param uid       用户uid
     * @return java.util.List&lt;result.vo.message.InteractiveMessageResult&gt;
     * @author Pan Juncai
     * @date 2019/7/29 17:18
     */
    List<InteractiveMessageResult> listInteractivePage(Page<InteractiveMessageResult> pageParam,
                                                       @Param("uid") Long uid);

    /**
     * 根据用户uid分页获取该用户的关注消息
     *
     * @param pageParam 分页参数
     * @param uid       用户uid
     * @return java.util.List&lt;result.vo.message.FollowMessageResult&gt;
     * @author Pan Juncai
     * @date 2019/7/30 9:55
     */
    List<FollowMessageResult> listFollowPage(Page<FollowMessageResult> pageParam, @Param("uid") Long uid);

    /**
     * 根据用户uid分页获取该用户的小助手消息列表
     *
     * @param pageParam 分页信息
     * @param uid       用户uid
     * @return java.util.List&lt;result.vo.message.HelperMessageResult&gt;
     * @author Pan Juncai
     * @date 2019/7/30 14:06
     */
    List<HelperMessageResult> listHelperPage(Page<HelperMessageResult> pageParam, @Param("uid") Long uid);
}
