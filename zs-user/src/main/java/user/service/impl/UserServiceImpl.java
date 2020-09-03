package user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.base.Strings;
import constant.Constant;
import enums.FollowStatusEnum;
import enums.UserStatusEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import request.PageParam;
import request.RpcAnswerParameter;
import request.TopicInviteParameter;
import request.TopicParameter;
import request.user.UidPageParameter;
import result.vo.*;
import result.vo.user.RecommendUserInfoResult;
import result.vo.user.UserBaseInfoResult;
import user.entity.*;
import user.mapper.*;
import user.rpcservice.RpcAnswerService;
import user.service.IUserFriendService;
import user.service.IUserService;
import util.TimeToolUtil;
import util.ZsUtil;
import util.jwt.JwtHelper;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author xc
 * @since 2019-05-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserTokenMapper userTokenMapper;

    @Resource
    private UserThirdMapper userThirdMapper;

    @Resource
    private TopicInviteMapper topicInviteMapper;

    @Resource
    private MessageMapper messageInvitationMapper;

    @Resource
    private IUserFriendService userFriendService;

    @Resource
    private RpcAnswerService rpcAnswerService;

    @Override
    public LoginUser getLoginUser(String token) {
        try {
            Map<String, String> userInfo = JwtHelper.verifyToken(token);
            Long uid = Long.valueOf(userInfo.get("uid"));
            User user = baseMapper.selectById(uid);
            LoginUser result = new LoginUser();
            BeanUtils.copyProperties(user, result);
            return result;

        } catch (UnsupportedEncodingException e) {
            // TOKEN校验失败
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserResult registerOrlogin(String phone) {

        // 返回封装
        UserResult result = new UserResult();

        // 查询该手机号是否存在
        User param = new User();
        param.setPhone(phone);
        User query = baseMapper.selectOne(param);

        if (query == null) {
            // 新建用户记录
            User insert = new User();
            insert.setPhone(phone);
            insert.setCreateTime(new Date());

            insert.setUname(ZsUtil.hidePhone(phone));
            insert.setGender(0);
            insert.setStatus(1);
            baseMapper.insert(insert);


            Long uid = insert.getUid();
            //使用新的jwtToken 不存放token到数据库
            Map<String, String> claims = new HashMap<>();
            claims.put("uid", uid.toString());
            claims.put("uName", ZsUtil.hidePhone(phone));
            claims.put("loginTime", TimeToolUtil.parseDateToString(new Date(), TimeToolUtil.DATEFORMAT_Y4_MM_DD_HMS));
            String jwtToken = JwtHelper.genToken(claims);


            insert.setUserNumber(ZsUtil.createNewNo(Constant.UPPER_B, uid));
            baseMapper.updateAllColumnById(insert);

            result.setIsRegister(1);
            result.setUToken(jwtToken);
            result.setUname(insert.getUname());
            result.setGender(2);
            result.setUid(uid);

        } else {

            Long uid = query.getUid();

            // 该用户被冻结
            if (query.getStatus() == 2) {
                result.setStatus(2);
                return result;
            }

//            // 更新登录信息
//            UserToken queryToken = new UserToken();
//            queryToken.setUid(query.getUid());
//            UserToken queryInfo = userTokenMapper.selectOne(queryToken);
//            queryInfo.setLoginTime(new Date());
//            queryInfo.setStatus(1);
//            // 更新token
//            String tokenStr = ZsUtil.getNewGUID();
//            queryInfo.setTokenContent(tokenStr);
//            userTokenMapper.updateById(queryInfo);

            //使用新的jwtToken 不存放token到数据库
            Map<String, String> claims = new HashMap<>();
            claims.put("uid", uid.toString());
            claims.put("uName", query.getUname());
            claims.put("loginTime", TimeToolUtil.parseDateToString(new Date(), TimeToolUtil.DATEFORMAT_Y4_MM_DD_HMS));
            String jwtToken = JwtHelper.genToken(claims);

            result.setIsRegister(0);
            result.setUToken(jwtToken);
            result.setUname(query.getUname());
            result.setGender(query.getGender());
            result.setHeadUrl(query.getHeadurl());
            result.setUid(uid);
            result.setUserSignature(query.getUserSignature());
        }
        // 状态1 为正常用户
        result.setStatus(1);

        // 填充统计数据：关注数、粉丝数、赞同数(正常回答和评论总赞数)
        result.setFollowCount(userFriendService.countFollowByUid(result.getUid()));
        result.setFansCount(userFriendService.countFansByUid(result.getUid()));
        result.setLikeCount(rpcAnswerService.countAnswerLikeTotalByUid(result.getUid())
                + rpcAnswerService.countCommentLikeTotalByUid(result.getUid()));
        return result;
    }

    @Override
    public boolean updateUname(Long uid, String uname) {
        User updateUser = new User();
        updateUser.setUid(uid);
        updateUser.setUname(uname);
        updateUser.setUpdataTime(new Date());
        int i = baseMapper.updateById(updateUser);
        if (i == Constant.SYSTEM_ONE) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<AnswerReuslt> getRecentlyUserInfo(List<AnswerReuslt> list) {
        List<AnswerReuslt> recentlyList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (AnswerReuslt topicResult : list) {
                User user = baseMapper.selectById(topicResult.getUid());
                if (user != null) {
                    topicResult.setUname(user.getUname());
                    topicResult.setHeadurl(topicResult.getHeadurl());
                    recentlyList.add(topicResult);
                }
            }
        }
        return recentlyList;
    }

    @Override
    public Page<InvitationUserResult> getTopicUserList(final Integer pageNum, final Integer pageSize,
                                                       final String searchKey,Long tid) {
        final Page<InvitationUserResult> result = new Page<>(pageNum, pageSize);
        String searchkey = null;
        if (searchKey != null) {
            searchkey = "%" + searchKey + "%";
        }
        return result.setRecords(baseMapper.getTopicUserList(searchkey,tid));
    }

    @Override
    public boolean wxUpdatePhone(final LoginUser user, final String phone, final String token) {
        // user对象，当前微信登录对象
        final Long wxUid = user.getUid();

        // 查询该手机号是否存在
        final User param = new User();
        param.setPhone(phone);
        // query对象，根据手机号查询出来的对象
        final User query = baseMapper.selectOne(param);

        // 不存在则绑定手机号
        if (query == null) {
            final User insertUser = new User();
            BeanUtils.copyProperties(user, insertUser);
            insertUser.setPhone(phone);
            insertUser.setStatus(1);
            insertUser.setUpdataTime(new Date());
            insertUser.setUserNumber(ZsUtil.createNewNo(Constant.UPPER_B, wxUid));
            baseMapper.updateById(insertUser);
            return true;
        } else {
            final Long queryUid = query.getUid();

            // 存在则查询该手机号用户是否绑定过微信，绑定过则更新失败
            final UserThird userThird = new UserThird();
            userThird.setUid(queryUid);
            final UserThird queryThird = userThirdMapper.selectOne(userThird);
            // 绑定过则更新失败
            if (queryThird != null) {
                return false;
            } else {
                // 没有绑定过，则更新信息
                // 1更新token登录信息
                final UserToken queryToken = new UserToken();
                queryToken.setUid(wxUid);
                final UserToken queryInfo = userTokenMapper.selectOne(queryToken);
                queryInfo.setLoginTime(new Date());
                queryInfo.setStatus(1);
                userTokenMapper.updateById(queryInfo);

                // 2更新第三方信息
                final UserThird upThird = new UserThird();
                userThird.setUid(wxUid);
                final UserThird queryupThird = userThirdMapper.selectOne(upThird);
                queryupThird.setUid(query.getUid());
                queryupThird.setUpdateTime(new Date());
                userThirdMapper.updateById(queryupThird);

                // 删除多余的用户信息
                baseMapper.deleteById(wxUid);
                // 删除无效的登录信息
                final EntityWrapper<UserToken> wrapper = new EntityWrapper<>();
                wrapper.eq("uid", queryUid);
                userTokenMapper.delete(wrapper);
                return true;
            }

        }
    }

    @Override
    public List<RpcAnswerParameter> getReplyUserInfo(final RpcAnswerParameter param) {
        return baseMapper.getReplyUserInfoList(param.getSearchKey(), param.getId());
    }

    @Override
    public Page<WebUserResult> getUserList(Integer pageNum, Integer pageSize, Integer status, String startTime,
                                           String endTime, String searchKey) {
        Page<WebUserResult> page = new Page<>(pageNum, pageSize);
        if (StringUtils.isNotEmpty(searchKey)) {
            searchKey = "%" + searchKey + "%";
        }
        return page.setRecords(baseMapper.getUserList(page, status, searchKey, startTime, endTime));

    }

    @Override
    public Boolean updateUserStatus(final Long uid, final Integer status) {
        final User user = baseMapper.selectById(uid);
        if (user != null) {
            user.setStatus(status);
            baseMapper.updateById(user);
        }
        return true;
    }

    @Override
    public UserResult getUserInfoByUid(final Long uid) {
        final User user = baseMapper.selectById(uid);
        UserResult u = new UserResult();
        if (user != null) {
            u.setHeadUrl(user.getHeadurl());
            u.setUname(user.getUname());
        }
        return u;
    }

    @Override
    public int checkPhone(final String phone) {
        // 查询该手机号是否存在
        final User param = new User();
        param.setPhone(phone);
        // query对象，根据手机号查询出来的对象
        final User query = baseMapper.selectOne(param);
        if (query != null) {
            // 存在则查询该手机号用户是否绑定过微信
            final UserThird userThird = new UserThird();
            userThird.setUid(query.getUid());
            final UserThird queryupThird = userThirdMapper.selectOne(userThird);
            if (queryupThird != null) {
                // 2代表该手机号已经存在并且已经绑定微信
                return 2;
            } else {
                // 1代表该手机号已经存在但是没有绑定微信
                return 1;
            }
        }

        // 0代表该手机号在系统中没有，可以注册
        return 0;
    }

    @Override
    public List<RecommendUserResult> getSystemRecommendUser(Long uid, Long tid) {
        return baseMapper.getSystemRecommendUser(uid, tid);
    }

    @Override
    public Boolean InvitationUser(Long createUid, Long uid, Long tid, Integer type) {
        Date createTime = new Date();

        // 查询是否邀请过
        EntityWrapper<TopicInvite> query = new EntityWrapper<>();
        query.eq("type", type);
        query.eq("create_uid", createUid);
        query.eq("tid", tid);
        query.eq("uid", uid);
        int queryCount = topicInviteMapper.selectCount(query);
        if (queryCount == 0) {
            TopicInvite entity = new TopicInvite();
            entity.setCreateTime(createTime);
            entity.setCreateUid(createUid);
            entity.setTid(tid);
            entity.setType(type);
            entity.setUid(uid);
            int i = topicInviteMapper.insert(entity);
            if (i == 1) {

                // 新建消息
                Message msg = new Message();
                msg.setCreateTime(createTime);
                msg.setCreateUid(createUid);
                msg.setMessageContent("话题内容");
                msg.setFromUid(uid);
                msg.setType(2);
                msg.setRelationId(tid);
                msg.setCreateUidType(0);
                messageInvitationMapper.insert(msg);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean WebInvitationUser(TopicParameter param) {
        Date createTime = new Date();
        try {
            Long tid = param.getTid();
            List<TopicInviteParameter> list = param.getInviteList();
            if (list != null) {
                for (TopicInviteParameter userParam : list) {
                    Long fromUid = userParam.getUid();

                    TopicInvite invite = new TopicInvite();
                    invite.setUid(fromUid);
                    invite.setTid(tid);
                    invite.setType(1);
                    invite.setCreateUid(param.getUaid());
                    invite.setCreateTime(createTime);
                    topicInviteMapper.insert(invite);

                    // 新建消息
                    Message msg = new Message();
                    msg.setCreateTime(createTime);
                    msg.setCreateUid(param.getUaid());
                    msg.setFromUid(fromUid);
                    msg.setType(2);
                    msg.setRelationId(tid);
                    msg.setCreateUidType(1);
                    messageInvitationMapper.insert(msg);
                }
                return true;
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public Boolean updateUserInfoByUid(User user) {
        return baseMapper.updateUserInfoByUid(user);
    }

    @Override
    public List<RecommendUserInfoResult> listRecommendedUser(Long loginUid) {
        return baseMapper.listRecommendedUser(loginUid);
    }

    @Override
    public List<RecommendUserInfoResult> listUserByUnameOrPhone(String searchKey, Long loginUid) {
        return baseMapper.listUserByUnameOrPhone(searchKey, loginUid);
    }

    @Override
    public Page<RecommendUserInfoResult> listFollowUserPageByUid(Long uid, PageParam page) {
        Page<RecommendUserInfoResult> pageResult = new Page<>(page.getPageNum(), page.getPageSize());
        List<RecommendUserInfoResult> list = baseMapper.listFollowUserPageByUid(uid, pageResult);
        pageResult.setRecords(list);
        return pageResult;
    }

    @Override
    public Page<RecommendUserInfoResult> listMyFansPage(Long uid, PageParam page) {
        Page<RecommendUserInfoResult> pageResult = new Page<>(page.getPageNum(), page.getPageSize());
        List<RecommendUserInfoResult> list = baseMapper.listMyFansPage(uid, pageResult);
        pageResult.setRecords(list);
        return pageResult;
    }

    @Override
    public UserResult refreshUserInfo(Long uid, String token) {
        User user = baseMapper.selectById(uid);

        UserResult userResult = new UserResult();
        if (null == user) {
            return userResult;
        }
        BeanUtils.copyProperties(user, userResult);
        userResult.setHeadUrl(user.getHeadurl());
        userResult.setUToken(token);
        userResult.setIsRegister(0);

        // 填充统计数据：关注数、粉丝数、赞同数(回答总赞数)
        userResult.setFollowCount(userFriendService.countFollowByUid(userResult.getUid()));
        userResult.setFansCount(userFriendService.countFansByUid(userResult.getUid()));
        userResult.setLikeCount(rpcAnswerService.countAnswerLikeTotalByUid(userResult.getUid())
                + rpcAnswerService.countCommentLikeTotalByUid(userResult.getUid()));

        return userResult;
    }

    @Override
    public UserBaseInfoResult getUserInfoByUid(Long uid, Long loginUid) {
        User user = baseMapper.selectById(uid);
        if (null == user || user.getStatus() == UserStatusEnum.FROZEN_USER.getStatus()) {
            return null;
        }
        UserBaseInfoResult userBaseInfoResult = new UserBaseInfoResult();
        BeanUtils.copyProperties(user, userBaseInfoResult);
        userBaseInfoResult.setHeadUrl(user.getHeadurl());

        // 填充统计数据：关注数、粉丝数、赞同数(回答总赞数)
        userBaseInfoResult.setFollowCount(userFriendService.countFollowByUid(user.getUid()));
        userBaseInfoResult.setFansCount(userFriendService.countFansByUid(user.getUid()));
        userBaseInfoResult.setLikeCount(rpcAnswerService.countAnswerLikeTotalByUid(user.getUid())
                + rpcAnswerService.countCommentLikeTotalByUid(user.getUid()));

        // 获取关注状态
        if (null == loginUid) {
            userBaseInfoResult.setFollowStatus(0);
        } else {
            userBaseInfoResult.setFollowStatus(userFriendService.getUserFollowStatus(loginUid, uid));
        }

        return userBaseInfoResult;
    }

    @Override
    public Page<RecommendUserInfoResult> listPersonFollowPage(UidPageParameter param, Long loginUid) {
        PageParam pageParam = new PageParam();
        BeanUtils.copyProperties(param, pageParam);
        // 查询关注分页
        Page<RecommendUserInfoResult> page = this.listFollowUserPageByUid(param.getUid(), pageParam);
        // 完善关注状态字段
        completeFollowStatus(page, loginUid);
        return page;
    }

    @Override
    public Page<RecommendUserInfoResult> listPersonFansPage(UidPageParameter param, Long loginUid) {
        PageParam pageParam = new PageParam();
        BeanUtils.copyProperties(param, pageParam);
        // 查询粉丝分页
        Page<RecommendUserInfoResult> page = this.listMyFansPage(param.getUid(), pageParam);
        // 完善关注状态字段
        completeFollowStatus(page, loginUid);
        return page;
    }

    /**
     * 完善分页里面的关注状态字段
     *
     * @param page     分页用户分页
     * @param loginUid 登录用户uid，为null时默认为未关注
     * @return void
     * @author Pan Juncai
     * @date 2019/7/30 16:49
     */
    private void completeFollowStatus(Page<RecommendUserInfoResult> page, Long loginUid) {
        if (null != page && null != page.getRecords()) {
            page.getRecords().forEach(userInfoResult -> {
                // 未登录用户默认为未关注
                Integer followStatus = FollowStatusEnum.UN_FOLLOW.getStatus();
                if (null != loginUid) {
                    followStatus = userFriendService.getUserFollowStatus(loginUid, userInfoResult.getUid());
                }
                userInfoResult.setFollowStatus(followStatus);
            });
        }
    }
}
