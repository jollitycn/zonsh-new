package backstage.web.webapi.content;

import backstage.rpcservice.RpcAnswerService;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import request.ReportShieldParameter;
import request.UpdateTopicParameter;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import result.vo.LoginUser;
import result.vo.TopicReplyResult;
import result.vo.comment.AnswerDetailPc;
import result.vo.comment.AnswerReportDetailResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Xc
 * @version 创建时间：2019年7月17日 下午2:52:41
 * @ClassName 类名称
 * @Description 类描述
 */
@Api(value = "AnswerController", tags = {"回答监控"})
@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    private RpcAnswerService rpcAnswerService;


    @ApiOperation("pc-回答列表")
    @GetMapping("/answerList")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNum", value = "页数"),
            @ApiImplicitParam(name = "pageSize", value = "大小"),
            @ApiImplicitParam(name = "startTime", value = "开始时间"),
            @ApiImplicitParam(name = "endTime", value = "结束时间"),
            @ApiImplicitParam(name = "status", value = "状态（0正常 2屏蔽）"),
            @ApiImplicitParam(name = "count", value = "阅读数"),
            @ApiImplicitParam(name = "searchKey", value = "搜索关键字")})
    public Result getReplySearchList(Integer pageNum, Integer pageSize, Integer mark,
                                     String startTime, String endTime, Integer count, Integer status, String searchKey) {

        //判断搜索参数是否为空，不为空则进行封装
        if (!StringUtils.isEmpty(searchKey)) {
            searchKey = "%" + searchKey + "%";
        }

        //分页查询
        Page<TopicReplyResult> answerList = rpcAnswerService.getPcAnswerList(pageNum, pageSize, startTime,
                endTime, status, count, searchKey);
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                ResultConstans.SUCCESS_MSG, answerList);
    }


    @ApiOperation("pc-回答详情列表")
    @GetMapping("/answerDetail")
    public Result getAnswerDetail(
            @RequestParam(required = true, value = "aid") Long aid,
            @RequestParam(required = false, value = "arid") Long arid) {

        AnswerDetailPc answerDetail = rpcAnswerService.getAnswerDetail(aid,arid);

        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, answerDetail);
    }

    @ApiOperation("删除回答")
    @DeleteMapping("/delAnswer/{aid}")
    public Result deleteAnswer(@PathVariable(value = "aid") Long aid) {
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG,
                rpcAnswerService.deleteAnswer(aid));
    }

    @ApiOperation("屏蔽恢复回答")
    @PutMapping("/shieldOrRestore/{aid}")
    public Result answerShieldAndRestore(@PathVariable(value = "aid") Long aid,
                                         @RequestBody UpdateTopicParameter param) {
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG,
                rpcAnswerService.answerShieldAndRestore(aid, param.getStatus()));

    }

    @ApiOperation("回答举报列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNum", value = "页数"),
            @ApiImplicitParam(name = "pageSize", value = "大小"),
            @ApiImplicitParam(name = "startTime", value = "开始时间"),
            @ApiImplicitParam(name = "endTime", value = "结束时间"),
            @ApiImplicitParam(name = "count", value = "阅读数"),
            @ApiImplicitParam(name = "searchKey", value = "搜索关键字")})
    @GetMapping("/report/list")
    public Result getAnswerReportList(Integer pageNum, Integer pageSize,
                                      String startTime, String endTime, Integer count, String searchKey) {
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG,
                rpcAnswerService.getAnswerReportList(pageNum, pageSize,
                        startTime, endTime, count, searchKey));
    }


    @ApiOperation("回答举报删除")
    @DeleteMapping("/report/delete/{aid}")
    public Result DeleteAnswerReportByArid(@PathVariable(value = "aid") Long aid){
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                ResultConstans.SUCCESS_MSG, rpcAnswerService.deleteAnswerReportByArid(aid));
    }
}


