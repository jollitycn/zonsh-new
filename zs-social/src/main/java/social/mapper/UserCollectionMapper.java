package social.mapper;

import social.entity.UserCollection;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * app用户收藏表 Mapper 接口
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-23
 */
public interface UserCollectionMapper extends BaseMapper<UserCollection> {
    /**
     * 判断数据是否被该用户收藏过：0未收藏  1已收藏
     *
     * @param uid            用户uid
     * @param collectionType 收藏类型
     * @param dataId         收藏的对应数据主键id
     * @return java.lang.Integer
     * @author Pan Juncai
     * @date 2019/7/31 12:25
     */
    Integer isCollection(@Param("uid") Long uid, @Param("collectionType") Integer collectionType,
                         @Param("dataId") Long dataId);
}
