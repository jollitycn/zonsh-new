package user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import constant.Constant;
import enums.MessageTypeEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import request.user.RpcBulletinMessageParameter;
import user.entity.Message;
import user.entity.UserFriend;
import user.mapper.UserFriendMapper;
import user.service.IMessageService;
import user.service.IUserFriendService;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * app用户关注表 服务实现类
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-09
 */
@Service
public class UserFriendServiceImpl extends ServiceImpl<UserFriendMapper, UserFriend> implements IUserFriendService {

    @Resource
    private IMessageService messageService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean followUser(Long loginUid, Long followUid) {
        // 1.查询关注
        UserFriend userFriend = new UserFriend();
        userFriend.setUid(loginUid);
        userFriend.setFollowUid(followUid);
        UserFriend selectUser = baseMapper.selectOne(userFriend);
        if (null != selectUser) {
            // 2.已经关联过
            return false;
        }
        // 3.还未关注过：判断是否互关，在新增关联，修改两个被关注的isFriend
        UserFriend insertUserFriend = new UserFriend();
        insertUserFriend.setUid(loginUid);
        insertUserFriend.setFollowUid(followUid);
        // 默认非互关
        insertUserFriend.setIsFriend(0);

        // 4.查询被关注
        UserFriend userFriend2 = new UserFriend();
        userFriend2.setUid(followUid);
        userFriend2.setFollowUid(loginUid);
        UserFriend selectUser2 = baseMapper.selectOne(userFriend2);

        if (null != selectUser2) {
            // 互关
            insertUserFriend.setIsFriend(1);
            // 修改成为互关
            UserFriend updateUserFriend = new UserFriend();
            updateUserFriend.setUfid(selectUser2.getUfid());
            updateUserFriend.setIsFriend(1);
            baseMapper.updateById(updateUserFriend);
        }
        // 插入关注
        baseMapper.insert(insertUserFriend);

        // 添加一条关注消息
        RpcBulletinMessageParameter messageParameter = new RpcBulletinMessageParameter();
        messageParameter.setType(MessageTypeEnum.FOLLOW.getType());
        messageParameter.setRelationId(insertUserFriend.getUfid());
        messageParameter.setCreateUidType(Constant.SYSTEM_ZERO);
        messageParameter.setFromUid(insertUserFriend.getFollowUid());
        messageParameter.setCreateUid(insertUserFriend.getUid());
        messageParameter.setMessageTitle("关注了你");
        // 消息入库
        messageService.addMessage(messageParameter);

        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean unFollowUser(Long loginUid, Long unFollowUid) {
        // 删除关注关系
        EntityWrapper<UserFriend> wrapper = new EntityWrapper<>();
        wrapper.eq("uid", loginUid);
        wrapper.eq("follow_uid", unFollowUid);
        List<UserFriend> follow = baseMapper.selectList(wrapper);
        if (null == follow || follow.isEmpty()) {
            return false;
        }
        baseMapper.delete(wrapper);

        // 查询被关注关系
        UserFriend userFriend = new UserFriend();
        userFriend.setUid(unFollowUid);
        userFriend.setFollowUid(loginUid);
        UserFriend selectUserFriend = baseMapper.selectOne(userFriend);
        if (null != selectUserFriend) {
            // 修改成为非互关
            UserFriend updateUserFriend = new UserFriend();
            updateUserFriend.setUfid(selectUserFriend.getUfid());
            updateUserFriend.setIsFriend(0);
            baseMapper.updateById(updateUserFriend);
        }

        // 删除对应的关注消息
        EntityWrapper<Message> messageWrapper = new EntityWrapper<>();
        messageWrapper.eq("type", MessageTypeEnum.FOLLOW.getType());
        messageWrapper.eq("relation_id", follow.get(0).getUfid());
        messageService.delete(messageWrapper);

        return true;
    }

    @Override
    public Long countFollowByUid(Long uid) {
        return baseMapper.countFollowByUid(uid);
    }

    @Override
    public Long countFansByUid(Long uid) {
        return baseMapper.countFansByUid(uid);
    }

    @Override
    public Integer getUserFollowStatus(Long uid, Long followUid) {
        return baseMapper.getUserFollowStatus(uid, followUid);
    }
}
