package backstage.web.webapi.admins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backstage.rpcservice.RpcUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import request.UpdateTopicParameter;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;

/**
* @author Xc
* @version 创建时间：2019年7月17日 下午3:48:20
* @ClassName 类名称
* @Description 类描述
*/
@Api(value = "AnswerController", tags = {"用户"})
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private RpcUserService rpcUserService;
	
	
	@ApiOperation("用户列表")
	@GetMapping("/userList")
	@ApiImplicitParams({ 
			@ApiImplicitParam(name = "status", value = "状态（ 1正常  2冻结）", dataType = "int"),
			@ApiImplicitParam(name = "mark", value = "时间（1.今天 2本周 3本月）", dataType = "int"),
			@ApiImplicitParam(name = "pageNum", value = "分页编号", dataType = "int"),
			@ApiImplicitParam(name = "pageSize", value = "分页大小", dataType = "int"),
			@ApiImplicitParam(name = "time", value = "指定时间", dataType = "string"),
			@ApiImplicitParam(name = "searchKey", value = "搜索关键字", dataType = "string") })
	public Result getUserList(
			@RequestParam(required = true, value = "pageNum") Integer pageNum,
			@RequestParam(required = true, value = "pageSize") Integer pageSize,
			@RequestParam(required = false, value = "status") Integer status,
			@RequestParam(required = false, value = "startTime") String startTime,
			@RequestParam(required = false, value = "endTime") String endTime,
			@RequestParam(required = false, value = "searchKey") String searchKey) {

		return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG,
				rpcUserService.getUserList(pageNum, pageSize, status, startTime, endTime, searchKey));
	}

	@ApiOperation("用户状态变更")
	@PutMapping("/changeUserStatus/{uid}")
	public Result updateUserStatus(@PathVariable(required = true, value = "uid") final Long uid,
			@RequestBody final UpdateTopicParameter param) {
		return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG,
				rpcUserService.updateUserStatus(uid, param.getStatus()));
	}
	

}


