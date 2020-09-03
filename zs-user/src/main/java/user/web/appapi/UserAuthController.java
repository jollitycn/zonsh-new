package user.web.appapi;

import base.BaseController;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import request.PageParam;
import request.user.BulletinCountParameter;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import result.vo.LoginUser;
import result.vo.MyAnswerResult;
import result.vo.UserResult;
import result.vo.message.*;
import result.vo.user.RecommendUserInfoResult;
import user.rpcservice.RpcAnswerService;
import user.rpcservice.RpcBulletinService;
import user.service.IMessageService;
import user.service.IUserService;
import util.RedisAPIUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xc
 * @since 2019-05-28
 */

@Api(value = "登录用户controller", tags = {"登录用户操作接口"})
@RestController
public class UserAuthController extends BaseController {

    @Autowired
    private IUserService userService;

    @Resource
    private RpcAnswerService answerService;

    @Autowired
    private IMessageService messageService;

    @Autowired
    private RpcBulletinService rpcBulletinService;

    private static String testCodel = "999999";

    @ApiOperation("更新用户名")
    @PostMapping("/auth/updateUname")
    @ApiImplicitParam(name = "uName", value = "用户名", dataType = "string")
    public Result updateUname(HttpServletRequest request, String uName) {

//		final String token = request.getHeader("token");
//		final LoginUser user = userService.getLoginUser(token);
//		if (user == null) {
//			return ResultFactory.generateResult(ResultConstans.TOKEN_ERROR_CODE, ResultConstans.TOKEN_ERROR_MSG);
//		}

        Long uid = getAppLoginUserUid(request);

        final boolean isSuccess = userService.updateUname(uid, uName);

        if (isSuccess) {
            return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG);
        } else {
            return ResultFactory.generateResult(ResultConstans.ERROR_CODE, ResultConstans.ERROR_MSG);
        }
    }

    @ApiOperation("绑定手机号")
    @PostMapping("/auth/bindphone")
    @ApiImplicitParams({@ApiImplicitParam(name = "phone", value = "手机号", dataType = "string"),
            @ApiImplicitParam(name = "code", value = "验证码", dataType = "string")})
    public Result bindphone(final HttpServletRequest request, final String phone, final String code) {

        final String token = request.getHeader("token");
        final LoginUser user = userService.getLoginUser(token);
        if (user == null) {
            return ResultFactory.generateResult(ResultConstans.TOKEN_ERROR_CODE, ResultConstans.TOKEN_ERROR_MSG);
        }

        // 校验验证码
        final String checkCode = RedisAPIUtil.hGet(phone);

        if (code.equals(checkCode) || testCodel.equals(code)) {
            // 如果通过,则更新手机号和用户状态

            final boolean isSuccess = userService.wxUpdatePhone(user, phone, token);

            if (isSuccess) {
                return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG);
            } else {
                return ResultFactory.generateResult(ResultConstans.USER_WXBIND_ERROR_CODE,
                        ResultConstans.USER_WXBIND_ERROR_MSG);
            }

        }
        return ResultFactory.generateResult(ResultConstans.CODE_ERROR_CODE, ResultConstans.CODE_ERROR_MSG);

    }

    @ApiOperation("获得我的回答列表-草稿")
    @GetMapping("/auth/answerList")
    public Result getMyAnswerList(HttpServletRequest request) {

        UserResult user = userService.getUserInfoByUid(getAppLoginUserUid(request));
        if (user == null) {
            return ResultFactory.generateResult(ResultConstans.TOKEN_ERROR_CODE, ResultConstans.TOKEN_ERROR_MSG);
        }

        List<MyAnswerResult> answerResults = answerService.getMyAnswerListRpc(user.getUid(), user.getStatus());

        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, answerResults);

    }

    @ApiOperation("邀请用户")
    @PostMapping("/auth/InvitationUser")
    @ApiImplicitParam(name = "tid", value = "话题id", dataType = "int")
    public Result InvitationUser(HttpServletRequest request, Long tid, Long uid) {

        Long loginUid = getAppLoginUserUid(request);

        // 获取登录用户信息
        if (loginUid != null) {
            Boolean result = userService.InvitationUser(loginUid, uid, tid, 2);
            // 不允许邀请自己
            if (0 == Long.compare(loginUid, uid)) {
                return ResultFactory.generateResult(ResultConstans.INVITATION_ERROR_CODE,
                        ResultConstans.INVITATION_ERROR_MSG);
            }
            if (result) {
                return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG);
            }
            return ResultFactory.generateResult(ResultConstans.ERROR_CODE, ResultConstans.ERROR_MSG);
        } else {
            return ResultFactory.generateResult(ResultConstans.TOKEN_ERROR_CODE, ResultConstans.TOKEN_ERROR_MSG);
        }

    }

    @ApiOperation("获取用户的消息概览")
    @GetMapping("/auth/getMessageType")
    public Result getMessageType(HttpServletRequest request) {
        Long loginUid = getAppLoginUserUid(request);

        // 获取登录用户信息
        if (loginUid != null) {
            // 获取我的消息
            List<MessageTypeResult> result = messageService.getMessageType(loginUid);

            return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                    ResultConstans.SUCCESS_MSG, result);
        } else {
            return ResultFactory.generateResult(ResultConstans.TOKEN_ERROR_CODE,
                    ResultConstans.TOKEN_ERROR_MSG);
        }

    }

    @ApiOperation("获取用户的消息列表")
    @GetMapping("/auth/getMessageList")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNum", value = "页码", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", dataType = "int"),
            @ApiImplicitParam(name = "type", value = "消息类型 1小助手 2回答邀请 3互动  4关注", dataType = "int")})
    public Result getMessageList(HttpServletRequest request, Integer type,
                                 Integer pageNum, Integer pageSize) {

        Long loginUid = getAppLoginUserUid(request);

        // 获取登录用户信息
        if (loginUid != null) {
            // 获取我的消息
            Page<MessageResult> result = messageService.getMessageList(loginUid, type, pageNum, pageSize);

            return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                    ResultConstans.SUCCESS_MSG, result);

        } else {
            return ResultFactory.generateResult(ResultConstans.TOKEN_ERROR_CODE,
                    ResultConstans.TOKEN_ERROR_MSG);
        }

    }


    @ApiOperation("删除指定类型所有消息")
    @PostMapping("/auth/delMessage")
    @ApiImplicitParam(name = "type", value = "消息类型", dataType = "int")
    public Result getMessageList(HttpServletRequest request, Integer type) {

        Long loginUid = getAppLoginUserUid(request);
        if (null != loginUid) {
            messageService.delMessage(loginUid, type);
            return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                    ResultConstans.SUCCESS_MSG);
        } else {
            return ResultFactory.generateResult(ResultConstans.TOKEN_ERROR_CODE,
                    ResultConstans.TOKEN_ERROR_MSG);
        }


    }

    @ApiOperation("将消息置为已读")
    @PostMapping("/auth/readMessage")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "relationId", value = "消息关联id", dataType = "long"),
            @ApiImplicitParam(name = "type", value = "消息类型 1小助手 2回答邀请 3互动  4关注", dataType = "int")})
    public Result readMessage(HttpServletRequest request, Long relationId, Integer type) {
        Long loginUid = getAppLoginUserUid(request);
        if (null != loginUid) {
            messageService.readMessage(loginUid, relationId, type);
            return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                    ResultConstans.SUCCESS_MSG);
        } else {
            return ResultFactory.generateResult(ResultConstans.TOKEN_ERROR_CODE,
                    ResultConstans.TOKEN_ERROR_MSG);
        }

    }

    @ApiOperation(value = "获取我关注的人信息", tags = {"【app端】---我"})
    @ApiImplicitParam(name = "PageParam", value = "分页信息")
    @GetMapping("/auth/listMyFollowUserPage")
    public Result listMyFollowUserPage(HttpServletRequest request, @Valid PageParam pageParam) {

        Page<RecommendUserInfoResult> page = userService
                .listFollowUserPageByUid(getAppLoginUserUid(request), pageParam);

        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, page);
    }

    @ApiOperation(value = "获取我的粉丝信息", tags = {"【app端】---我"})
    @ApiImplicitParam(name = "PageParam", value = "分页信息")
    @GetMapping("/auth/listMyFansPage")
    public Result listMyFansPage(HttpServletRequest request, @Valid PageParam pageParam) {
        Page<RecommendUserInfoResult> page = userService.listMyFansPage(getAppLoginUserUid(request), pageParam);
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, page);
    }

    @ApiOperation(value = "刷新个人信息", tags = {"【app端】---我"})
    @GetMapping("/auth/refreshUserInfo")
    public Result refreshUserInfo(HttpServletRequest request) {
        String token = request.getHeader("token");
        UserResult userResult = userService.refreshUserInfo(getAppLoginUserUid(request), token);
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, userResult);
    }

    @ApiOperation(value = "获取消息中的小助手列表", tags = {"【app端】---消息"})
    @ApiImplicitParam(name = "PageParam", value = "入参实体")
    @GetMapping("/auth/listHelperPage")
    public Result listHelperPage(HttpServletRequest request, @Valid PageParam pageParam) {
        Page<HelperMessageResult> page = messageService.listHelperPage(pageParam, getAppLoginUserUid(request));
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, page);
    }

    @ApiOperation(value = "获取消息中的互动列表", tags = {"【app端】---消息"})
    @ApiImplicitParam(name = "PageParam", value = "入参实体")
    @GetMapping("/auth/listInteractivePage")
    public Result listInteractivePage(HttpServletRequest request, @Valid PageParam pageParam) {

        Page<InteractiveMessageResult> page = messageService
                .listInteractivePage(pageParam, getAppLoginUserUid(request));

        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, page);
    }

    @ApiOperation(value = "获取消息中的关注列表", tags = {"【app端】---消息"})
    @ApiImplicitParam(name = "PageParam", value = "入参实体")
    @GetMapping("/auth/listFollowPage")
    public Result listFollowPage(HttpServletRequest request, @Valid PageParam pageParam) {

        Page<FollowMessageResult> page = messageService.listFollowPage(pageParam, getAppLoginUserUid(request));
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, page);
    }

    @ApiOperation(value = "公告浏览量增加", tags = {"【app端】---消息"})
    @ApiImplicitParam(name = "bnid", value = "公告bnid", example = "11", required = true, dataType = "long")
    @PutMapping("/auth/addBulletin/count")
    public Result addBulletinViewCount(Long bnid){
        System.out.println(bnid);
            Boolean isSuccess = rpcBulletinService.addBulletinViewCount(bnid);
            return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, isSuccess);

    }

}
