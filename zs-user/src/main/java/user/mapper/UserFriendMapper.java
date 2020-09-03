package user.mapper;

import org.apache.ibatis.annotations.Param;
import user.entity.UserFriend;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * app用户关注表 Mapper 接口
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-09
 */
public interface UserFriendMapper extends BaseMapper<UserFriend> {

    /**
     * 统计用户的关注数
     *
     * @param uid 用户uid
     * @return java.lang.Long
     * @author Pan Juncai
     * @date 2019/7/12 16:05
     */
    Long countFollowByUid(@Param("uid") Long uid);

    /**
     * 统计用户粉丝数
     *
     * @param uid 用户uid
     * @return java.lang.Long
     * @author Pan Juncai
     * @date 2019/7/12 16:05
     */
    Long countFansByUid(@Param("uid") Long uid);

    /**
     * 获取两用户的关注状态：返回值 0 未关注  1 已关注  2 互相关注
     *
     * @param uid       关注人uid
     * @param followUid 被关注人uid
     * @return java.lang.Integer
     * @author Pan Juncai
     * @date 2019/7/26 11:08
     */
    Integer getUserFollowStatus(@Param("uid") Long uid, @Param("followUid") Long followUid);

}
