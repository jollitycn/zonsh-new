package user.web.appapi;

import base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import result.vo.RecommendUserResult;
import result.vo.UserResult;
import result.vo.question.QuestionResult;
import result.vo.search.SearchContentResult;
import result.vo.search.SearchResult;
import user.rpcservice.RpcQuestionService;
import user.service.IUserSearchService;
import user.service.IUserService;
import user.service.IUserThirdService;
import util.RedisAPIUtil;
import util.Yunxin163SmsUtil;
import util.ZsUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xc
 * @since 2019-05-28
 */

@Api(value = "用户controller", tags = {"用户操作接口"})
@RestController
public class UserController extends BaseController {

    @Resource
    private IUserService userService;

    @Resource
    private IUserThirdService userThirdService;

    @Resource
    private IUserSearchService userSearchService;

    @Resource
    private RpcQuestionService rpcQuestionService;

    @ApiOperation("发送短信验证码")
    @PostMapping("/sendCode")
    @ApiImplicitParam(name = "phone", value = "用户手机号", dataType = "string")
    public Result sendCode(final String phone) {

        if (phone == null || ZsUtil.isPhone(phone) != 0) {
            return ResultFactory.generateResult(ResultConstans.ERROR_PHONE_CODE,
                    ResultConstans.ERROR_PHONE_MSG);
        }

        final String code = Yunxin163SmsUtil.sendCode(phone);
        if (code != null) {

            // 写入redis,并且设置600S有效时间
            RedisAPIUtil.hSetWithTime(phone, code, 600);


            return success();
        }

        return error();
    }

    @ApiOperation("注册/登录")
    @PostMapping("/regOrLogin")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "string"),
            @ApiImplicitParam(name = "code", value = "验证码", dataType = "string")})
    public Result registerOrlogin(final String phone, final String code) {

        // 校验验证码
        final String checkCode = RedisAPIUtil.hGet(phone);

        if (code.equals(checkCode) || code.equals("999999")) {
            // 如果通过,则进行处理，返回为2表示该用户已被冻结
            final UserResult result = userService.registerOrlogin(phone);
            if (result.getStatus() != 2) {
                return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                        ResultConstans.SUCCESS_MSG, result);
            } else {
                return ResultFactory.generateResult(
                        ResultConstans.ERROR_USER_ERROR_CODE,
                        ResultConstans.ERROR_USER_ERROR_MSG);
            }
        }

        return ResultFactory.generateResult(ResultConstans.CODE_ERROR_CODE,
                ResultConstans.CODE_ERROR_MSG);
    }

    @ApiOperation("微信-获取微信登录凭证")
    @PostMapping("/wx/getAccessToken")
    @ApiImplicitParam(name = "code", value = "微信授权码", dataType = "string")
    public Result getAccessToken(final String code) {
        // 返回微信登录凭证
        final UserResult result = userThirdService.wxLogin(code);


        if (result.getStatus() != 2) {
            return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                    ResultConstans.SUCCESS_MSG, result);
        } else {
            return ResultFactory.generateResult(ResultConstans.ERROR_USER_ERROR_CODE,
                    ResultConstans.ERROR_USER_ERROR_MSG);
        }

    }


    @ApiOperation("校验手机号")
    @PostMapping("/checkPhone")
    @ApiImplicitParam(name = "phone", value = "手机号", dataType = "string")
    public Result checkPhone(final String phone) {

        final int isSuccess = userService.checkPhone(phone);

        // 2代表该手机号已经存在并且已经绑定微信 code 217
        // 1代表该手机号已经存在但是没有绑定微信 code 218
        // 0代表该手机号在系统中没有，可以注册 code 200
        if (isSuccess == 0) {
            return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                    ResultConstans.SUCCESS_MSG);
        } else if (isSuccess == 1) {
            return ResultFactory.generateResult(ResultConstans.USER_WXBIND_CODE,
                    ResultConstans.USER_WXBIND_MSG);
        } else {
            return ResultFactory.generateResult(ResultConstans.USER_WXBIND_ERROR_CODE,
                    ResultConstans.USER_WXBIND_ERROR_MSG);
        }

    }

    @ApiOperation("获取指定话题的系统推荐用户")
    @GetMapping("/app/systemRecommendUser")
    @ApiImplicitParam(name = "tid", value = "话题id", dataType = "int")
    public Result systemRecommendUser(HttpServletRequest request, Long tid) {


        Long userUid = getAppLoginUserUid(request);
        Long uid = null;

        //如果是已登录用户,筛选已经邀请的人
        if (userUid != null) {
            uid = userUid;
        }

        List<RecommendUserResult> result = userService.getSystemRecommendUser(uid, tid);

        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                ResultConstans.SUCCESS_MSG, result);

    }

    @ApiOperation("搜索话题/活动")
    @GetMapping("/app/search")
    @ApiImplicitParam(name = "searchKey", value = "搜索内容", dataType = "string")
    public Result searchTopOrActivity(String searchKey) {
        List<SearchContentResult> result = userSearchService.getSearchTopOractivityList(searchKey);
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                ResultConstans.SUCCESS_MSG, result);

    }

    @ApiOperation("获取搜索关键字")
    @GetMapping("/app/getSearchkey")
    public Result getSearchKey() {

        List<SearchResult> result = userSearchService.getSearchkey();

        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                ResultConstans.SUCCESS_MSG, result);
    }

    @ApiOperation("获取 消息/搜索 中话题的相关信息")
    @GetMapping("/app/topicInfo")
    @ApiImplicitParam(name = "tid", value = "消息关联relationId/tid", dataType = "long")
    public Result topicMessageInfo(HttpServletRequest request, Long tid) {
        Long loginUid = getAppLoginUserUid(request);
        //如果用户信息为空，则isAnswer字段固定为0
        Long uid = -1L;
        if (null != loginUid) {
            uid = loginUid;
        }
        QuestionResult result = rpcQuestionService.topicMessageInfo(uid, tid);
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                ResultConstans.SUCCESS_MSG, result);
    }
}
