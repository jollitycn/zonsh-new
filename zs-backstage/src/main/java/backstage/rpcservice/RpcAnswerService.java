package backstage.rpcservice;

import com.baomidou.mybatisplus.plugins.Page;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import request.comment.QueryCommentPageParameter;
import result.vo.AnswerReuslt;
import result.vo.TopicReplyResult;
import result.vo.comment.*;

import java.util.Date;
import java.util.List;

/**
 * @author wangJin
 * @date 2019年6月14日 下午2:56:27
 */
@FeignClient(value = "comment")
public interface RpcAnswerService {

  @GetMapping("/app/answer/listRpc")
  Page<AnswerReuslt> getAppAnswerList(@RequestParam(value = "tid") Long tid,
      @RequestParam(value = "pageNum") Integer pageNum,
      @RequestParam(value = "pageSize") Integer pageSize);


  @GetMapping("/answer/count")
  Integer getAnswerCountByTid(@RequestParam(value = "tid") Long tid);

  /**
   * 获取评论列表分页
   *
   * @param param 查询条件
   * @return result.Result
   * @author Pan Juncai
   * @date 2019/7/3 18:50
   */
  @GetMapping("/comment/listCommentAndReplyPage")
  Page<CommentOrReplyResult> listCommentAndReplyPage(
      @RequestParam(required = true, value = "pageNum") Integer pageNum,
      @RequestParam(required = true, value = "pageSize") Integer pageSize,
      @RequestParam(required = true, value = "status") Integer status,
      @RequestParam(required = false, value = "commentType") String commentType,
      @RequestParam(required = false, value = "searchKey") String searchKey,
      @RequestParam(required = false, value = "startTime") String startTime,
      @RequestParam(required = false, value = "endTime") String endTime);

  /**
   * 查看详情
   *
   * @param cid 评论的主键cid
   * @return result.vo.comment.CommentDetailResult
   * @author Pan Juncai
   * @date 2019/7/3 21:14
   */
  @GetMapping("/comment/getCommentDetail/{cid}")
  CommentDetailResult getCommentDetail(@PathVariable(value = "cid") Long cid);

  /**
   * 屏蔽评论的使用
   *
   * @param cid 评论主键cid
   * @return java.lang.Boolean
   * @author Pan Juncai
   * @date 2019/7/3 21:13
   */
  @PutMapping("/comment/shieldingComment/{cid}")
  Boolean shieldingComment(@PathVariable(value = "cid") Long cid);

  /**
   * 恢复评论的使用
   *
   * @param cid 评论主键cid
   * @return java.lang.Boolean
   * @author Pan Juncai
   * @date 2019/7/3 21:13
   */
  @PutMapping("/reuseComment/{cid}")
  Boolean reuseComment(@PathVariable(value = "cid") Long cid);


  @GetMapping("/answerList")
  Page<TopicReplyResult> getPcAnswerList(
      @RequestParam(value = "pageNum") Integer pageNum,
      @RequestParam(value = "pageSize") Integer pageSize,
      @RequestParam(value = "startTime") String startTime,
      @RequestParam(value = "endTime") String endTime,
      @RequestParam(value = "status") Integer status,
      @RequestParam(value = "count") Integer count,
      @RequestParam(value = "searchKey") String searchKey);


  @GetMapping("/answerDetail")
  AnswerDetailPc getAnswerDetail(@RequestParam(value = "aid") Long aid,
      @RequestParam(value = "arid") Long arid);

  @DeleteMapping("/delAnswer/{aid}")
  Boolean deleteAnswer(@PathVariable(value = "aid") Long aid);

  @PutMapping("/shieldOrRestoreAnswer")
  Boolean answerShieldAndRestore(
      @RequestParam(required = true, value = "aid") Long aid,
      @RequestParam(required = true, value = "status") Integer status);

  @GetMapping("/answer/report/list")
  Page<AnswerReportResult> getAnswerReportList(@RequestParam(value = "pageNum") Integer pageNum,
      @RequestParam(value = "pageSize") Integer pageSize,
      @RequestParam(value = "startTime") String startTime,
      @RequestParam(value = "endTime") String endTime,
      @RequestParam(value = "count") Integer count,
      @RequestParam(value = "searchKey") String searchKey);

  /**
   * 删除举报回答
   *
   * @param aid 举报id
   * @return Boolean
   */
  @DeleteMapping("/report/delete/{aid}")
  Boolean deleteAnswerReportByArid(@PathVariable(value = "aid") Long aid);

  /**
   *获取评论举报列表
   */
  @GetMapping("/report/list")
  Page<CommentReportResult> getCommentReportList(@RequestParam(value = "pageNum") Integer pageNum,
      @RequestParam(value = "pageSize") Integer pageSize,
      @RequestParam(value = "commentType") String commentType,
      @RequestParam(value = "searchKey") String searchKey,
      @RequestParam(value = "startTime") String startTime,
      @RequestParam(value = "endTime") String endTime);

  /**
   * 获取评论举报详情
   */
  @GetMapping("/detail/report/{arid}")
  CommentReportDetailResult getCommentReportDetail(@RequestParam(value = "arid") Long arid);


}


