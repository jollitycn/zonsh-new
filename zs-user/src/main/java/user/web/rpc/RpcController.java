package user.web.rpc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import request.RpcAnswerParameter;
import request.TopicParameter;
import request.UpdateTopicParameter;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import result.vo.AnswerReuslt;
import result.vo.InvitationUserResult;
import result.vo.LoginUser;
import result.vo.UserResult;
import result.vo.WebUserResult;
import springfox.documentation.annotations.ApiIgnore;
import user.service.IUserService;

/**
 * <p>
 * 用户服务对外提供的服务
 * </p>
 *
 * @author xc
 * @since 2019-05-28
 */

// 远程调用控制器
@RestController
public class RpcController {

	@Autowired
	private IUserService userService;

	// 获取用户信息
	@GetMapping("/user/uid")
	public UserResult getUserInfoByUid(@RequestParam(value = "uid") Long uid) {
		return userService.getUserInfoByUid(uid);
	}

	/**
	 * @param list
	 * @return
	 */
	@PostMapping("/user/list")
	public List<AnswerReuslt> getRecentlyUserInfo(@RequestBody List<AnswerReuslt> list) {// 测试后面使用
		return userService.getRecentlyUserInfo(list);
	}

	@PostMapping("/getLoginUser")
	public LoginUser getLoginUser(String token) {
		return userService.getLoginUser(token);
	}

	@ApiIgnore()
	@ApiOperation("获取用户邀请列表")
	@GetMapping("/topicUserList")
	public Page<InvitationUserResult> topicUserList(
			@RequestParam(required = true,value = "pageNum")  Integer pageNum,
			@RequestParam(required = true,value = "pageSize") Integer pageSize,
			@RequestParam(required = false,value = "searchKey") String searchKey,
			@RequestParam(required = false,value = "tid")Long tid) {
		return userService.getTopicUserList(pageNum, pageSize, searchKey,tid);
	}

	@PostMapping("/reply/user/info")
	public List<RpcAnswerParameter> getReplyUserInfo(@RequestBody final RpcAnswerParameter param) {

		return userService.getReplyUserInfo(param);
	}

	@ApiOperation("用户列表")
	@GetMapping("/userList")
	public Page<WebUserResult> getUserList(
			@RequestParam(required = true, value = "pageNum") Integer pageNum,
			@RequestParam(required = true, value = "pageSize") Integer pageSize,
			@RequestParam(required = false, value = "status") Integer status,
			@RequestParam(required = false, value = "startTime") String startTime,
			@RequestParam(required = false, value = "endTime") String endTime,
			@RequestParam(required = false, value = "searchKey") String searchKey) {

		return userService.getUserList(pageNum, pageSize, status, startTime, endTime, searchKey);
	}

	/**
	 * 用户状态变更
	 * @param uid
	 * @param param
	 * @return
	 */
	@PutMapping("/changeUserStatus")
	public Boolean updateUserStatus(
			@RequestParam(required = true, value = "uid") Long uid,
			@RequestParam(required = true, value = "status") Integer status) {
		return 	userService.updateUserStatus(uid, status);
	}
	
	
	/**
	 * 后台添加邀请
	 * @param uid
	 * @param param
	 * @return
	 */
	@PostMapping("/web/addInvitation")
	public Boolean addInvitation(@RequestBody TopicParameter  param) {
		
		return userService.WebInvitationUser(param);
		
	}
	
	
}
