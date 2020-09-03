package user.service;

import com.baomidou.mybatisplus.service.IService;
import user.entity.UserFriend;

/**
 * <p>
 * app用户关注表 服务类
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-09
 */
public interface IUserFriendService extends IService<UserFriend> {

    /**
     * 关注用户：
     * 先查询是否存在关注关系，若有则返回false，如无，则反查是否有被该用户关注；
     * 若有两条数据修改为互关状态，若无，则互关状态为0
     *
     * @param loginUid  登录用户uid
     * @param followUid 关注用户uid
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/9 18:16
     */
    Boolean followUser(Long loginUid, Long followUid);

    /**
     * 取消关注：
     * 删除关联关系，如果有被关注的关系，修改isFriend为0
     *
     * @param loginUid    登录用户uid
     * @param unFollowUid 取消关注用户uid
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/9 18:16
     */
    Boolean unFollowUser(Long loginUid, Long unFollowUid);

    /**
     * 统计用户的关注数
     *
     * @param uid 用户uid
     * @return java.lang.Long
     * @author Pan Juncai
     * @date 2019/7/12 16:05
     */
    Long countFollowByUid(Long uid);

    /**
     * 统计用户粉丝数
     *
     * @param uid 用户uid
     * @return java.lang.Long
     * @author Pan Juncai
     * @date 2019/7/12 16:05
     */
    Long countFansByUid(Long uid);

    /**
     * 获取两用户的关注状态：返回值 0 未关注  1 已关注  2 互相关注
     *
     * @param uid       关注人uid
     * @param followUid 被关注人uid
     * @return java.lang.Integer
     * @author Pan Juncai
     * @date 2019/7/26 11:08
     */
    Integer getUserFollowStatus(Long uid, Long followUid);

}
