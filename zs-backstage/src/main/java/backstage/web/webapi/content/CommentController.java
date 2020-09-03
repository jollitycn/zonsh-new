package backstage.web.webapi.content;

import backstage.rpcservice.RpcAnswerService;
import com.google.common.base.Strings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import request.comment.QueryCommentPageParameter;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author Xc
 * @version 创建时间：2019年7月17日 下午2:52:41
 * @ClassName 类名称
 * @Description 类描述
 */
@Api(value = "CommentController", tags = {"评论"})
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private RpcAnswerService rpcAnswerService;

    @ApiOperation("获取评论列表分页")
    @ApiImplicitParam(name = "QueryCommentPageParameter", value = "查询条件实体")
    @GetMapping("/commentList")
    public Result listCommentAndReplyPage(@RequestParam(required = true, value = "pageNum") Integer pageNum,
                                          @RequestParam(required = true, value = "pageSize") Integer pageSize,
                                          @RequestParam(required = true, value = "status") Integer status,
                                          @RequestParam(required = false, value = "commentType") String commentType,
                                          @RequestParam(required = false, value = "searchKey") String searchKey,
                                          @RequestParam(required = false, value = "startTime") String startTime,
                                          @RequestParam(required = false, value = "endTime") String endTime) {
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG,
                rpcAnswerService.listCommentAndReplyPage(pageNum, pageSize, status, commentType, searchKey, startTime, endTime));
    }

    @ApiOperation("查看详情")
    @ApiImplicitParam(name = "cid", value = "评论的主键cid")
    @GetMapping("/commentDetail/{cid}")
    public Result getCommentDetail(@Valid @NotNull(message = "上级评论的cid不能为空")
                                   @Min(value = 1L, message = "parentCid最小为1")
                                   @Max(value = Long.MAX_VALUE, message = "parentCid超过最大值")
                                   @PathVariable Long cid) {
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG,
                rpcAnswerService.getCommentDetail(cid));
    }

    @ApiOperation("屏蔽评论")
    @ApiImplicitParam(name = "cid", value = "评论的cid")
    @PutMapping("/shieldingComment/{cid}")
    public Result shieldingComment(@Valid @NotNull(message = "上级评论的cid不能为空")
                                   @Min(value = 1L, message = "parentCid最小为1")
                                   @Max(value = Long.MAX_VALUE, message = "parentCid超过最大值")
                                   @PathVariable Long cid) {
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG,
                rpcAnswerService.shieldingComment(cid));
    }

    @ApiOperation("恢复评论")
    @ApiImplicitParam(name = "cid", value = "评论的cid")
    @PutMapping("/reuseComment/{cid}")
    public Result reuseComment(@Valid @NotNull(message = "上级评论的cid不能为空")
                               @Min(value = 1L, message = "parentCid最小为1")
                               @Max(value = Long.MAX_VALUE, message = "parentCid超过最大值")
                               @PathVariable Long cid) {
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG,
                rpcAnswerService.reuseComment(cid));
    }

    @ApiOperation("获取评论举报列表")
    @GetMapping("/report/list")
    public Result getCommentReportList(@RequestParam(required = true, value = "pageNum") Integer pageNum,
                                       @RequestParam(required = true, value = "pageSize") Integer pageSize,
                                       @RequestParam(required = false, value = "commentType") String commentType,
                                       @RequestParam(required = false, value = "searchKey") String searchKey,
                                       @RequestParam(required = false, value = "startTime") String startTime,
                                       @RequestParam(required = false, value = "endTime") String endTime
    ) {
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG,
                rpcAnswerService.getCommentReportList(pageNum, pageSize, commentType, searchKey, startTime, endTime));
    }

    @ApiOperation("查看评论举报详情")
    @ApiImplicitParam(name = "arid", value = "举报主键arid")
    @GetMapping("/detail/report/{arid}")
    public Result getCommentReportDetail(
                                         @PathVariable(required = true,value="arid") Long arid) {
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG,
                rpcAnswerService.getCommentReportDetail(arid));
    }
}


