package social.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import social.entity.Comment;
import org.apache.ibatis.annotations.Param;
import result.vo.comment.CommentOrReplyResult;
import result.vo.comment.CommentReplyResult;
import result.vo.comment.CommentReportResult;

import java.util.List;

/**
 * <p>
 * 评论表 Mapper 接口
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-10
 */
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 根据一级评论的commentCode查询二级评论以及回复
     * 【注】：uid为了查询点赞、收藏、举报状态
     *
     * @param commentCode 一级评论的commentCode
     * @param uid         用户uid
     * @return java.util.List&lt;result.vo.comment.CommentReplyResult&gt;
     * @author Pan Juncai
     * @date 2019/7/10 20:02
     */
    List<CommentReplyResult> listReplyByCommentCode(@Param("commentCode") String commentCode, @Param("uid") Long uid);

    /**
     * 根据问题id查询回答标题
     *
     * @param aid 问题id
     * @return java.lang.String
     * @author Pan Juncai
     * @date 2019/7/3 16:09
     */
    String getAnswerTitleByAid(@Param("aid") Long aid);

    /**
     * 根据活动id查询活动标题
     *
     * @param aid 活动id
     * @return java.lang.String
     * @author Pan Juncai
     * @date 2019/7/3 16:19
     */
    String getActivityTitleByAid(@Param("aid") Long aid);

    /**
     * 根据cid删除（修改状态）登录用户自己的评论，包含下级评论
     *
     * @param cid      要删除的评论的cid
     * @param loginUid 登录用户uid
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/11 15:55
     */
    Boolean deleteCommentWithLowerByCid(@Param("cid") Long cid, @Param("loginUid") Long loginUid);

    /**
     * 删除自己评论的评论
     * 【注】:不包含下级,只删除这一条；若有下级评论或者回复（包含屏蔽的），有则删除不了本条，无则直接删除数据
     *
     * @param cid      评论id
     * @param loginUid 登录用户id
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/16 17:34
     */
    Boolean deleteCommentByCid(@Param("cid") Long cid, @Param("loginUid") Long loginUid);

    /**
     * 根据cid，批量修改评论（包含下级）的状态
     *
     * @param cid    评论id
     * @param status 修改后状态
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/11 17:57
     */
    Boolean updateStatusWithLowerByCid(@Param("cid") Long cid, @Param("status") Integer status);


    /**
     * web端 分页查询评论的列表
     *
     * @param page      分页
     * @param pageNum   分页大小
     * @param status    状态
     * @param pageSize  页面大小
     * @param typeList  类型列表
     * @param searchKey 搜索值
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return List
     */
    List<CommentOrReplyResult> listCommentAndReplyPage(Page<CommentOrReplyResult> page,
                                                       @Param("pageNum") Integer pageNum,
                                                       @Param("status") Integer status,
                                                       @Param("pageSize") Integer pageSize,
                                                       @Param("typeList") List<Integer> typeList,
                                                       @Param("searchKey") String searchKey,
                                                       @Param("startTime") String startTime,
                                                       @Param("endTime") String endTime);

    /**
     * 根据Aid删除对应的评论
     *
     * @param aid 回答id
     */
    void deleteCommentByAid(Long aid);

    /**
     * 获取评论举报列表
     *
     * @param page            分页
     * @param pageNum         分页大小
     * @param pageSize        页面大小
     * @param commentTypeList 类型列表
     * @param searchKey       搜索值
     * @param startTime       开始时间
     * @param endTime         结束时间
     * @return List
     */

    List<CommentReportResult> getCommentReportList(Page<CommentReportResult> page,
                                                   @Param("pageNum") Integer pageNum,
                                                   @Param("pageSize") Integer pageSize,
                                                   @Param("commentTypeList") List<Integer> commentTypeList,
                                                   @Param("searchKey") String searchKey,
                                                   @Param("startTime") String startTime,
                                                   @Param("endTime") String endTime);

    /**
     * 用户点赞
     *
     * @param cid 点赞评论的cid
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/24 16:31
     */
    Boolean userGiveLike(@Param("cid") Long cid);

    /**
     * 用户取消点赞
     *
     * @param cid 点赞评论的cid
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/26 16:31
     */
    Boolean cancelUserLike(@Param("cid") Long cid);

    /**
     * 根据用户uid查询该用户所有【正常】评论获得的总赞数
     *
     * @param uid 用户uid
     * @return java.lang.Long
     * @author Pan Juncai
     * @date 2019/7/26 9:17
     */
    Long countCommentLikeTotalByUid(@Param("uid") Long uid);
}
