package user.web.appapi;

import base.BaseController;
import com.baomidou.mybatisplus.plugins.Page;
import com.netflix.ribbon.proxy.annotation.Http;
import enums.UserStatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import request.user.UidPageParameter;
import request.user.UserBaseInfoParameter;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import result.vo.LoginUser;
import result.vo.comment.MyAnswerWithTopicResult;
import result.vo.user.RecommendUserInfoResult;
import result.vo.user.UserBaseInfoResult;
import user.entity.User;
import user.rpcservice.RpcAnswerService;
import user.service.IUserFriendService;
import user.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/8 16:27
 */
@Api(value = "app用户信息controller")
@RestController
public class AppUserInfoController extends BaseController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserFriendService userFriendService;

    @Resource
    private RpcAnswerService rpcAnswerService;

    @ApiOperation(value = "修改个人信息", tags = {"【app端】---我"})
    @PutMapping("/auth/updateUserInfo")
    @ApiImplicitParam(name = "UserBaseInfoParameter", value = "用户基本信息接收实体")
    public Result updateUserInfo(@Valid UserBaseInfoParameter parameter, HttpServletRequest request) {
        // 获取登录用户信息
        Long uid = getAppLoginUserUid(request);
        if (uid == null) {
            return ResultFactory.generateResult(ResultConstans.TOKEN_ERROR_CODE, ResultConstans.TOKEN_ERROR_MSG);
        }
        // 修改信息
        User user = new User();
        user.setUname(parameter.getUname());
        user.setHeadurl(parameter.getHeadurl());
        user.setUserSignature(parameter.getUserSignature());
        user.setUid(uid);
        Boolean isSuccess = userService.updateUserInfoByUid(user);

        return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
    }

    @ApiOperation(value = "交友---获取系统推荐用户", tags = {"【app端】---交友"})
    @GetMapping("/app/listRecommendedUser")
    public Result listRecommendedUser(HttpServletRequest request) {

        List<RecommendUserInfoResult> list = userService.listRecommendedUser(getAppLoginUserUid(request));

        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, list);
    }

    @ApiOperation(value = "根据昵称或者手机号模糊搜索用户信息", tags = {"【app端】---交友"})
    @ApiImplicitParam(name = "searchKey", value = "昵称/手机号", example = "张山", required = true)
    @GetMapping("/app/listUserByUnameOrPhone")
    public Result listUserByUnameOrPhone(String searchKey, HttpServletRequest request) {
        // 获取登录用户信息
        Long loginUid = getAppLoginUserUid(request);

        List<RecommendUserInfoResult> list = userService.listUserByUnameOrPhone(searchKey, loginUid);

        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, list);
    }

    @ApiOperation(value = "关注用户", tags = {"【app端】---交友"})
    @ApiImplicitParam(name = "followUid", value = "关注的用户uid", example = "11", required = true, dataType = "long")
    @PutMapping("/auth/followUser")
    public Result followUser(Long followUid, HttpServletRequest request) {
        // 获取登录用户信息
        Long uid = getAppLoginUserUid(request);
        if (uid == null) {
            return ResultFactory.generateResult(ResultConstans.TOKEN_ERROR_CODE, ResultConstans.TOKEN_ERROR_MSG);
        }

        Boolean isSuccess = userFriendService.followUser(uid, followUid);

        return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
    }

    @ApiOperation(value = "交友---取消关注", tags = {"【app端】---交友"})
    @ApiImplicitParam(name = "unFollowUid", value = "要取消关注的用户uid", example = "11", required = true, dataType = "long")
    @PutMapping("/auth/unFollowUser")
    public Result unFollowUser(Long unFollowUid, HttpServletRequest request) {
        // 获取登录用户信息
        Long uid = getAppLoginUserUid(request);
        if (uid == null) {
            return ResultFactory.generateResult(ResultConstans.TOKEN_ERROR_CODE, ResultConstans.TOKEN_ERROR_MSG);
        }

        Boolean isSuccess = userFriendService.unFollowUser(uid, unFollowUid);

        return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
    }

    @ApiOperation(value = "【个人主页】---该用户的基本信息", tags = "【个人主页】")
    @ApiImplicitParam(name = "uid", value = "用户uid", example = "11", required = true, dataType = "long")
    @GetMapping("/app/getUserInfoByUid")
    public Result getUserInfoByUid(Long uid, HttpServletRequest request) {

        UserBaseInfoResult userInfo = userService.getUserInfoByUid(uid, getAppLoginUserUid(request));
        // 用户不存在或者被冻结
        if (null == userInfo) {
            return ResultFactory.generateResult(ResultConstans.USER_NOT_EXIST_CODE, ResultConstans.USER_NOT_EXIST_MSG);
        }
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, userInfo);
    }

    @ApiOperation(value = "【个人主页】---该用户的回答列表", tags = "【个人主页】")
    @ApiImplicitParam(name = "UidPageParameter", value = "入参实体")
    @GetMapping("/app/listAnswerPageByUid")
    public Result listAnswerPageByUid(@Valid UidPageParameter param) {

        User userInfo = userService.selectById(param.getUid());
        // 用户不存在或者被冻结
        if (null == userInfo || userInfo.getStatus() == UserStatusEnum.FROZEN_USER.getStatus()) {
            return ResultFactory.generateResult(ResultConstans.USER_NOT_EXIST_CODE, ResultConstans.USER_NOT_EXIST_MSG);
        }
        Page<MyAnswerWithTopicResult> page = rpcAnswerService.
                listNormalAnswerPageByUid(param.getUid(), param.getPageNum(), param.getPageSize());
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, page);
    }

    @ApiOperation(value = "【个人主页】---分页获取该用户的关注列表", tags = "【个人主页】")
    @ApiImplicitParam(name = "UidPageParameter", value = "入参")
    @GetMapping("/app/listPersonFollowPage")
    public Result listPersonFollowPage(@Valid UidPageParameter param, HttpServletRequest request) {
        Page<RecommendUserInfoResult> page = userService.listPersonFollowPage(param, getAppLoginUserUid(request));
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, page);
    }

    @ApiOperation(value = "【个人主页】---分页获取该用户的粉丝列表", tags = "【个人主页】")
    @ApiImplicitParam(name = "UidPageParameter", value = "入参")
    @GetMapping("/app/listPersonFansPage")
    public Result listPersonFansPage(@Valid UidPageParameter param, HttpServletRequest request) {
        Page<RecommendUserInfoResult> page = userService.listPersonFansPage(param, getAppLoginUserUid(request));
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, page);
    }

}
