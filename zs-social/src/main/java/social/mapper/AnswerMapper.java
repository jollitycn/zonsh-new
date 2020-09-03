package social.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import social.entity.Answer;
import org.apache.ibatis.annotations.Param;
import request.RpcAnswerParameter;
import result.vo.AnswerReuslt;
import result.vo.MyAnswerResult;
import result.vo.SortParam;
import result.vo.TopicReplyResult;
import result.vo.comment.*;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xc
 * @since 2019-06-12
 */
public interface AnswerMapper extends BaseMapper<Answer> {

//	List<AnswerReuslt> getAppAnswerList(Page<AnswerReuslt> page, Long tid);

    List<AnswerReuslt> getAppAnswerList(Page<AnswerReuslt> page,
                                        @Param(value = "tid") Long tid, @Param(value = "uid") Long uid);

    /**
     * 根据回答aid获取所有图片
     *
     * @param aid 问题aid
     * @return java.util.List&lt;java.lang.String&gt;
     * @author Pan Juncai
     * @date 2019/7/25 11:04
     */
    List<String> getImageUrl(@Param("aid") Long aid);

    List<TopicReplyResult> getReplySearchList(Page<TopicReplyResult> page,
                                              @Param(value = "startTime") String startTime,
                                              @Param(value = "endTime") String endTime,
                                              @Param(value = "status") Integer status,
                                              @Param(value = "replyTopicList") List<RpcAnswerParameter> replyTopicList,
                                              @Param(value = "replyUserInfo") List<RpcAnswerParameter> replyUserInfo,
                                              @Param(value = "maxCount") Integer maxCount,
                                              @Param(value = "minCount") Integer minCount);

    AnswerDetail getAnswerDetail(@Param(value = "tid") Long tid,
                                 @Param(value = "aid") Long aid);

    Integer getAnswerCountByTid(@Param(value = "tid") Long tid);

    Integer getCommentCountByAid(@Param(value = "aid") Long aid);

    List<MyAnswerResult> getMyAnswerListRpc(@Param(value = "uid") Long uid, @Param(value = "status") Integer status);

    List<TopicReplyResult> getPcAnswerList(Page<TopicReplyResult> page,
                                           @Param(value = "startTime") String startTime,
                                           @Param(value = "endTime") String endTime,
                                           @Param(value = "status") Integer status,
                                           @Param(value = "count") Integer count,
                                           @Param(value = "searchKey") String searchKey);

    /**
     * 获取排名
     *
     * @param aid
     * @return
     */
    SortParam getSortParam(@Param(value = "aid") Long aid);

    /**
     * 根据用户uid查询该用户所有回答的总赞数
     *
     * @param uid 用户uid
     * @return java.lang.Long
     * @author Pan Juncai
     * @date 2019/7/12 16:22
     */
    Long countAnswerLikeTotalByUid(@Param("uid") Long uid);

    /**
     * 获取回答详情
     *
     * @param aid
     * @param arid
     * @return
     */
    AnswerDetailPc getAnswerDetailPc(@Param("aid") Long aid, @Param("arid") Long arid);

    /**
     * 根据uid分页获取该用户的回答列表（回答发布时间降序）
     *
     * @param page 分页参数
     * @param uid  用户uid
     * @return java.util.List&lt;result.vo.comment.MyAnswerWithTopicResult&gt;
     * @author Pan Juncai
     * @date 2019/7/23 14:39
     */
    List<MyAnswerWithTopicResult> listAnswerPageWithTopicByUid(Page<MyAnswerWithTopicResult> page,
                                                               @Param("uid") Long uid);

    /**
     * 根据uid分页获取该用户的正常的回答列表（回答发布时间降序）
     * 【注】：不包含屏蔽的回答
     *
     * @param page 分页参数
     * @param uid  用户uid
     * @return java.util.List&lt;result.vo.comment.MyAnswerWithTopicResult&gt;
     * @author Pan Juncai
     * @date 2019/7/26 13:25
     */
    List<MyAnswerWithTopicResult> listNormalAnswerPageByUid(Page<MyAnswerWithTopicResult> page, @Param("uid") Long uid);

    /**
     * 根据uid分页获取该用户的草稿列表（时间降序）
     *
     * @param page 分页参数
     * @param uid  用户uid
     * @return java.util.List&lt;result.vo.comment.MyAnswerDraftWithTopicResult&gt;
     * @author Pan Juncai
     * @date 2019/7/23 14:39
     */
    List<MyAnswerDraftWithTopicResult> listDraftPageWithTopicByUid(Page<MyAnswerDraftWithTopicResult> page,
                                                                   @Param("uid") Long uid);

    /**
     * 根据uid分页获取该用户的收藏的问题列表（收藏时间降序）
     *
     * @param page 分页参数
     * @param uid  用户uid
     * @return java.util.List&lt;result.vo.comment.MyCollectionOfAnswerResult&gt;
     * @author Pan Juncai
     * @date 2019/7/25 13:58
     */
    List<MyCollectionOfAnswerResult> listCollectionOfAnswerPageByUid(Page<MyCollectionOfAnswerResult> page,
                                                                     @Param("uid") Long uid);

    /**
     * 用户点赞
     *
     * @param aid 点赞回答aid
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/26 16:31
     */
    Boolean userGiveLike(@Param("aid") Long aid);

    /**
     * 取消点赞
     *
     * @param aid 点赞回答aid
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/24 16:31
     */
    Boolean cancelUserLike(@Param("aid") Long aid);

    /**
     * 回答的浏览量+1
     *
     * @param aid 回答aid
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/24 16:31
     */
    Boolean increaseViewCount(@Param("aid") Long aid);
}
