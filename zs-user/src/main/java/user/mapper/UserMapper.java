package user.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import request.RpcAnswerParameter;
import result.vo.InvitationUserResult;
import result.vo.RecommendUserResult;
import result.vo.WebUserResult;
import result.vo.user.RecommendUserInfoResult;
import user.entity.User;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xc
 * @since 2019-05-28
 */
public interface UserMapper extends BaseMapper<User> {

  List<InvitationUserResult> getTopicUserList(
      @Param(value = "searchkey") String searchkey,
      @Param(value = "tid") Long tid);

  List<RpcAnswerParameter> getReplyUserInfoList(
      @Param(value = "searchKey") String searchKey,
      @Param(value = "uid") Long uid);

  List<WebUserResult> getUserList(Page<WebUserResult> page,
      @Param(value = "status") Integer status,
      @Param(value = "searchKey") String searchKey,
      @Param(value = "startTime") String startTime,
      @Param(value = "endTime") String endTime);

  List<RecommendUserResult> getSystemRecommendUser(
      @Param(value = "uid") Long uid,
      @Param(value = "tid") Long tid);

  /**
   * app用户修改个人信息：昵称、头像、个人简介（均可为空）
   *
   * @param user 用户信息
   * @return java.lang.Boolean
   * @author Pan Juncai
   * @date 2019/7/9 11:29
   */
  Boolean updateUserInfoByUid(User user);

  /**
   * 获取推荐用户列表 规则：按照用户答题数量从高往低排（计算范围：回答字数需为80字以上），最多推荐15名用户。 【注】:若为登录用户则不查询自身为推荐用户，未登录用户查询所有
   *
   * @param loginUid 登录用户id，可为空
   * @return java.util.List&lt;request.user.RecommendedUserInfo&gt;
   * @author Pan Juncai
   * @date 2019/7/9 16:07
   */
  List<RecommendUserInfoResult> listRecommendedUser(@Param("loginUid") Long loginUid);

  /**
   * 根据昵称或者手机号模糊搜索用户信息
   *
   * @param searchKey 用户昵称或者手机号（模糊搜索）
   * @param loginUid 登录用户id
   * @return java.util.List&lt;request.user.RecommendedUserInfo&gt;
   * @author Pan Juncai
   * @date 2019/7/9 16:07
   */
  List<RecommendUserInfoResult> listUserByUnameOrPhone(@Param("searchKey") String searchKey,
      @Param("loginUid") Long loginUid);

  /**
   * 根据用户uid分页查询该用户关注的用户信息
   *
   * @param uid 用户uid
   * @param page 分页信息
   * @return java.util.List&lt;result.vo.user.RecommendUserInfoResult&gt;
   * @author Pan Juncai
   * @date 2019/7/12 17:40
   */
  List<RecommendUserInfoResult> listFollowUserPageByUid(@Param("uid") Long uid,
      Page<RecommendUserInfoResult> page);

  /**
   * 根据用户uid分页查询该用户粉丝的信息
   *
   * @param uid 用户uid
   * @param page 分页信息
   * @return java.util.List&lt;result.vo.user.RecommendUserInfoResult&gt;
   * @author Pan Juncai
   * @date 2019/7/12 17:40
   */
  List<RecommendUserInfoResult> listMyFansPage(@Param("uid") Long uid,
      Page<RecommendUserInfoResult> page);
}
