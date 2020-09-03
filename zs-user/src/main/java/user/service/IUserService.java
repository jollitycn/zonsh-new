package user.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.bind.annotation.RequestParam;
import request.PageParam;
import request.RpcAnswerParameter;
import request.TopicParameter;
import request.user.UidPageParameter;
import result.vo.*;
import result.vo.user.RecommendUserInfoResult;
import result.vo.user.UserBaseInfoResult;
import user.entity.User;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author xc
 * @since 2019-05-28
 */
public interface IUserService extends IService<User> {

    /**
     * 获取app登录用户
     *
     * @param phone
     * @return
     */
    LoginUser getLoginUser(String token);

    /**
     * 用户注册或者登陆
     *
     * @param phone
     * @return
     */
    UserResult registerOrlogin(String phone);

    /**
     * 更新用户名
     *
     * @param user
     * @param uname
     * @return
     */
    boolean updateUname(Long uid, String uname);

    /**
     * 获取话题最新页面关联的用户
     *
     * @param list
     * @return
     */
    List<AnswerReuslt> getRecentlyUserInfo(List<AnswerReuslt> list);

    /**
     * 获取邀请用户列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<InvitationUserResult> getTopicUserList(Integer pageNum, Integer pageSize, String searchKey,Long tid);

    /**
     * 更新手机号
     *
     * @param user
     * @param phone
     * @return
     */
    boolean wxUpdatePhone(LoginUser user, String phone, String token);

    /**
     * 校验手机号
     *
     * @param phone
     * @return
     */
    int checkPhone(String phone);

    /**
     * 获取回答用户信息
     *
     * @return
     */
    List<RpcAnswerParameter> getReplyUserInfo(RpcAnswerParameter param);

    /**
     * PC-获取用户列表
     *
     * @param pageNum
     * @param pageSize
     * @param status
     * @param startTime
     * @param endTime
     * @param searchKey
     * @return
     */
    Page<WebUserResult> getUserList(@RequestParam(required = true, value = "pageNum") Integer pageNum,
                                    @RequestParam(required = true, value = "pageSize") Integer pageSize,
                                    @RequestParam(required = true, value = "status") Integer status,
                                    @RequestParam(required = false, value = "time") String startTime,
                                    @RequestParam(required = false, value = "time") String endTime,
                                    @RequestParam(required = false, value = "searchKey") String searchKey);

    /**
     * 修改用户状态
     *
     * @param uid
     * @param status
     * @return
     */
    Boolean updateUserStatus(Long uid, Integer status);

    /**
     * 根据用户id获取用户信息
     */

    UserResult getUserInfoByUid(Long uid);

    /**
     * 获取系统推荐的要求用户
     *
     * @param tid
     * @param uid
     * @return
     */
    List<RecommendUserResult> getSystemRecommendUser(Long uid, Long tid);

    /**
     * app邀请用户回答问题
     *
     * @param createUid
     * @param uid
     * @param tid
     * @param type      1系统邀请 2用户邀请
     * @return
     */
    Boolean InvitationUser(Long createUid, Long uid, Long tid, Integer type);

    /**
     * web端邀请用户回答问题
     *
     * @param param
     * @return
     */
    Boolean WebInvitationUser(TopicParameter param);

    /**
     * 修改登录用户的昵称和个人介绍（签名）
     *
     * @param user 修改信息
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/8 16:39
     */
    Boolean updateUserInfoByUid(User user);

    /**
     * 获取推荐用户列表
     * 规则：按照用户答题数量从高往低排（计算范围：回答字数需为80字以上），最多推荐15名用户。
     * 【注】:若为登录用户则不查询自身为推荐用户，未登录用户查询所有
     *
     * @param loginUid 登录用户id，可为空
     * @return java.util.List&lt;request.user.RecommendedUserInfo&gt;
     * @author Pan Juncai
     * @date 2019/7/9 16:07
     */
    List<RecommendUserInfoResult> listRecommendedUser(Long loginUid);

    /**
     * 根据昵称或者手机号模糊搜索用户信息
     *
     * @param searchKey 用户昵称或者手机号（模糊搜索）
     * @param loginUid  登录用户id
     * @return java.util.List&lt;request.user.RecommendedUserInfo&gt;
     * @author Pan Juncai
     * @date 2019/7/9 16:07
     */
    List<RecommendUserInfoResult> listUserByUnameOrPhone(String searchKey, Long loginUid);

    /**
     * 根据用户uid分页查询该用户关注的用户信息
     *
     * @param uid  用户uid
     * @param page 分页信息
     * @return java.util.List&lt;result.vo.user.RecommendUserInfoResult&gt;
     * @author Pan Juncai
     * @date 2019/7/12 17:40
     */
    Page<RecommendUserInfoResult> listFollowUserPageByUid(Long uid, PageParam page);

    /**
     * 根据用户uid分页查询该用户粉丝的信息
     *
     * @param uid  用户uid
     * @param page 分页信息
     * @return java.util.List&lt;result.vo.user.RecommendUserInfoResult&gt;
     * @author Pan Juncai
     * @date 2019/7/12 17:40
     */
    Page<RecommendUserInfoResult> listMyFansPage(Long uid, PageParam page);

    /**
     * 根据用户uid查询用户基本信息，包含关注数、粉丝数、赞同数
     *
     * @param uid   用户uid
     * @param token token
     * @return result.vo.UserResult
     * @author Pan Juncai
     * @date 2019/7/15 12:17
     */
    UserResult refreshUserInfo(Long uid, String token);

    /**
     * 根据用户uid查询用户基本信息，若用户已登陆则查询关注状态，未登录则默认为未关注
     *
     * @param uid      要查询的用户uid
     * @param loginUid 登录用户uid（可为空）
     * @return result.vo.user.UserBaseInfoResult
     * @author Pan Juncai
     * @date 2019/7/26 10:33
     */
    UserBaseInfoResult getUserInfoByUid(Long uid, Long loginUid);

    /**
     * 分页获取指定用户的关注人
     * 【个人主页的关注列表】：包含已登录用户：完善登录用户与该用户关注人的关系，未登录用户：默认为未关注状态
     *
     * @param param    分页参数和指定的用户uid
     * @param loginUid 当前登录用户uid，可为空
     * @return com.baomidou.mybatisplus.plugins.Page&lt;result.vo.user.RecommendUserInfoResult&gt;
     * @author Pan Juncai
     * @date 2019/7/30 16:05
     */
    Page<RecommendUserInfoResult> listPersonFollowPage(UidPageParameter param, Long loginUid);

    /**
     * 分页获取指定用户的粉丝列表
     * 【个人主页的粉丝列表】：包含已登录用户：完善登录用户与该用户关注人的关系，未登录用户：默认为未关注状态
     *
     * @param param    分页参数和指定的用户uid
     * @param loginUid 当前登录用户uid，可为空
     * @return com.baomidou.mybatisplus.plugins.Page&lt;result.vo.user.RecommendUserInfoResult&gt;
     * @author Pan Juncai
     * @date 2019/7/30 16:43
     */
    Page<RecommendUserInfoResult> listPersonFansPage(UidPageParameter param, Long loginUid);

}
