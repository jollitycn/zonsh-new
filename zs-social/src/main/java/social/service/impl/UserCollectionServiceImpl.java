package social.service.impl;

import social.entity.UserCollection;
import social.mapper.UserCollectionMapper;
import social.service.IUserCollectionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import enums.SourceTypeEnum;
import org.springframework.stereotype.Service;

/**
 * <p>
 * app用户收藏表 服务实现类
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-23
 */
@Service
public class UserCollectionServiceImpl extends ServiceImpl<UserCollectionMapper, UserCollection> implements IUserCollectionService {

    @Override
    public Integer isCollection(Long uid, SourceTypeEnum typeEnum, Long dataId) {
        return baseMapper.isCollection(uid, typeEnum.getType(), dataId);
    }
}
