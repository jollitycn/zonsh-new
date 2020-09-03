package backstage.web.webapi.content;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import backstage.web.webapi.base.BaseController;
import dto.LoginAuthDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.plugins.Page;
import backstage.rpcservice.RpcTopicService;
import backstage.rpcservice.RpcUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import request.TopicLabelParameter;
import request.TopicParameter;
import request.UpdateTopicParameter;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import result.vo.TopLabelResult;
import result.vo.TopicHomePageResult;
import result.vo.WebUserResult;

/**
* @author Xc
* @version 创建时间：2019年7月17日 上午11:39:17
* @ClassName 类名称
* @Description 类描述
*/
@Api(value = "QuestionController", tags = {"后台话题/问题接口"})
@RestController
@RequestMapping("/question")
public class QuestionController extends BaseController {

	@Autowired
	private RpcTopicService rpcTopicService;
	
	@Autowired
	private RpcUserService rpcUserService;
	
	
	@ApiOperation("pc-话题列表")
	@GetMapping("/topicList")
	public Result getTopicList(@RequestParam(required = true, value = "pageNum")  Integer pageNum,
			@RequestParam(required = true, value = "pageSize")  Integer pageSize,
			@RequestParam(required = true, value = "status")  Integer status,
			@RequestParam(required = false, value = "mark")  Integer mark,
			@RequestParam(required = false, value = "startTime")  String startTime,
			@RequestParam(required = false, value = "endTime")  String endTime,
			@RequestParam(required = false, value = "tlid")  Long tlid,
			@RequestParam(required = false, value = "searchKey")  String searchKey) {

		Page<TopicHomePageResult> topicList = rpcTopicService.getTopicList(pageNum, pageSize, mark, startTime,
				endTime, tlid, searchKey, status);

		return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, topicList);
	}
	
	@ApiOperation("pc-话题添加")
	@ApiImplicitParam(name = "TopicParameter", value = "话题添加对象")
	@PostMapping("/addTopic")
	public Result addTopic(@RequestBody  TopicParameter param, HttpServletRequest request) {
		LoginAuthDto loginUser=getLoginAuthDto();
		param.setUaid(loginUser.getUaid());
		Boolean isSuccess = rpcTopicService.addTopic(param);
		return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
				isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
	}
	
	@ApiOperation("话题上下架接口")
	@PutMapping("/upOrdownTopic")
	public Result upOrdownTopic(@RequestBody  UpdateTopicParameter param) {
		 Boolean isSuccess = rpcTopicService.upOrdownTopic(param.getTid(), param.getStatus());
		return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
				isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
	}
	
	@ApiOperation(value = "话题删除接口")
	@DeleteMapping("/delTopic/{tid}")
	public Result deleteTopic(
			@PathVariable(required = true, value = "tid")  Long tid) {
		 Boolean isSuccess = rpcTopicService.deleteTopic(tid); 
		return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
				isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
	}
	
	@ApiOperation("获取被邀请用户列表")
	@GetMapping("/invitationUserList")
	public Result getRecentlyUserInfo(	@RequestParam(required = true,value = "pageNum")  Integer pageNum,
			@RequestParam(required = true,value = "pageSize") Integer pageSize,
			@RequestParam(required = false,value = "searchKey") String searchKey,
			@RequestParam(required = false,value = "tid")Long tid) {
		return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG,
				rpcUserService.getTopicUserList(pageNum, pageSize, searchKey,tid));
	}
	
	@ApiOperation("邀请用户")
	@PostMapping("/addTopicinvite")
	public Result insertTopicInvite(@RequestBody TopicParameter param) {
		// 验证后台用户身份
		param.setUaid(getLoginAuthDto().getUaid());
		Boolean isSuccess = rpcUserService.insertTopicInvite(param);
		return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
				isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
	}
	
	
	
	@ApiOperation(value = "添加话题标签")
	@PostMapping("/addTopiclabel")
	public Result addLabel(@RequestBody  @Valid TopicLabelParameter param) {
		final Boolean isSuccess = rpcTopicService.addLabel(param);
		return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
				isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
	}

	@ApiOperation(value = "获取话题标签列表")
	@GetMapping("/labelList")
	public Result getLabelListBySearchKey(
			@RequestParam(required = false, value = "searchKey") String searchKey) {
		 List<TopLabelResult> labelList = rpcTopicService.getLabelList(searchKey);
		return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, 
				ResultConstans.SUCCESS_MSG, labelList);
	}

	@ApiOperation(value = "删除标签")
	@DeleteMapping("/delTopicLabel")
	public Result deleteLabel(@RequestBody TopicLabelParameter param) {
		 Boolean isSuccess = rpcTopicService.deleteLabel(param.getList());
		return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
				isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
	}


}



