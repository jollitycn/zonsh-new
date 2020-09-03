package social.service;

import social.entity.UserCollection;
import com.baomidou.mybatisplus.service.IService;
import enums.SourceTypeEnum;

/**
 * <p>
 * app用户收藏表 服务类
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-23
 */
public interface IUserCollectionService extends IService<UserCollection> {
    /**
     * 判断数据是否被该用户收藏过：0未收藏  1已收藏
     *
     * @param uid      用户uid
     * @param typeEnum 收藏类型
     * @param dataId   收藏的对应数据主键id
     * @return java.lang.Integer
     * @author Pan Juncai
     * @date 2019/7/31 12:25
     */
    Integer isCollection(Long uid, SourceTypeEnum typeEnum, Long dataId);
}
