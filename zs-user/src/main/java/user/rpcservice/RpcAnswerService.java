package user.rpcservice;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import result.vo.MyAnswerResult;
import result.vo.comment.MyAnswerWithTopicResult;
import user.rpcservice.impl.RpcAnswerServiceImpl;

import java.util.List;

/**
 * @author wangJin
 * @date 2019年5月31日 下午5:54:24
 */
@FeignClient(value = "comment",fallback = RpcAnswerServiceImpl.class)
public interface RpcAnswerService {

    /**
     * 获取我的回答信息
     *
     * @param uid    用户uid
     * @param status 回答状态
     * @return java.util.List&lt;result.vo.MyAnswerResult&gt;
     * @author Pan Juncai
     * @date 2019/7/12 16:35
     */
    @GetMapping("/app/answer/answerListRpc")
    List<MyAnswerResult> getMyAnswerListRpc(@RequestParam(value = "uid") Long uid,
                                            @RequestParam(value = "status") Integer status);

    /**
     * 统计用户的所有【正常】回答获得的总赞数
     *
     * @param uid 用户uid
     * @return java.lang.Integer
     * @author Pan Juncai
     * @date 2019/7/12 16:34
     */
    @GetMapping("/answer/countAnswerLikeTotalByUid")
    Long countAnswerLikeTotalByUid(@RequestParam(value = "uid") Long uid);

    /**
     * 统计用户的所有【正常】评论获得的总赞数
     *
     * @param uid 用户uid
     * @return java.lang.Long
     * @author Pan Juncai
     * @date 2019/7/26 9:24
     */
    @GetMapping("/comment/countCommentLikeTotalByUid")
    Long countCommentLikeTotalByUid(@RequestParam(value = "uid") Long uid);

    /**
     * 根据uid分页获取该用户的正常的回答列表（回答发布时间降序）
     * 【注】：不包含屏蔽的回答
     *
     * @param uid      要查询的用户uid
     * @param pageNum  当前页
     * @param pageSize 每页大小
     * @return com.baomidou.mybatisplus.plugins.Page&lt;result.vo.comment.MyAnswerWithTopicResult&gt;
     * @author Pan Juncai
     * @date 2019/7/26 13:40
     */
    @GetMapping("/app/listNormalAnswerPage")
    Page<MyAnswerWithTopicResult> listNormalAnswerPageByUid(@RequestParam(value = "uid") Long uid,
                                                            @RequestParam(value = "pageNum") Integer pageNum,
                                                            @RequestParam(value = "pageSize") Integer pageSize);

}
