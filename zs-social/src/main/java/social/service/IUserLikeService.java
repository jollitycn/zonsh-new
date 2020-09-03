package social.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import social.entity.UserLike;
import enums.SourceTypeEnum;
import request.PageParam;
import result.vo.comment.MyLikeResult;

/**
 * <p>
 * app用户点赞记录表 服务类
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-23
 */
public interface IUserLikeService extends IService<UserLike> {

    /**
     * 根据用户uid分页获取其点赞信息（点赞时间倒叙）
     *
     * @param pageParam 分页参数
     * @param uid       用户uid
     * @return com.baomidou.mybatisplus.plugins.Page&lt;result.vo.comment.MyLikeResult&gt;
     * @author Pan Juncai
     * @date 2019/7/25 16:50
     */
    Page<MyLikeResult> listMyUserLikePage(PageParam pageParam, Long uid);

    /**
     * 判断数据是否被点赞过：0未点赞  1已点赞
     *
     * @param uid      用户uid
     * @param typeEnum 点赞类型
     * @param dataId   点赞对应数据主键id
     * @return java.lang.Integer
     * @author Pan Juncai
     * @date 2019/7/31 12:25
     */
    Integer isLike(Long uid, SourceTypeEnum typeEnum, Long dataId);

}
