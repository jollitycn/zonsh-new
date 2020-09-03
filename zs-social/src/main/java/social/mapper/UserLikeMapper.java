package social.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import social.entity.UserLike;
import org.apache.ibatis.annotations.Param;
import result.vo.comment.MyLikeResult;

import java.util.List;

/**
 * <p>
 * app用户点赞记录表 Mapper 接口
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-23
 */
public interface UserLikeMapper extends BaseMapper<UserLike> {
    /**
     * 根据用户uid分页获取其点赞信息（点赞时间倒叙）
     *
     * @param page 分页参数
     * @param uid  用户uid
     * @return java.util.List&lt;result.vo.comment.MyLikeResult&gt;
     * @author Pan Juncai
     * @date 2019/7/25 17:00
     */
    List<MyLikeResult> listMyUserLikePageByUid(Page<MyLikeResult> page, @Param("uid") Long uid);

    /**
     * 判断数据是否被点赞过：0未点赞  1已点赞
     *
     * @param uid      用户uid
     * @param likeType 点赞类型
     * @param dataId   点赞对应数据主键id
     * @return java.lang.Integer
     * @author Pan Juncai
     * @date 2019/7/31 12:25
     */
    Integer isLike(@Param("uid") Long uid, @Param("likeType") Integer likeType, @Param("dataId") Long dataId);

}
