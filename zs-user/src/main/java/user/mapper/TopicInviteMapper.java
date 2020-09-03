package user.mapper;

import org.apache.ibatis.annotations.Param;
import user.entity.TopicInvite;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author xc
 * @since 2019-06-26
 */
public interface TopicInviteMapper extends BaseMapper<TopicInvite> {

  Integer getTopicInviteUser(@Param(value = "tid") Long tid, @Param(value = "uid") Long uid);

  void deleteInvitation(@Param(value = "tid") Long tid);
}
