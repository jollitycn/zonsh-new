package social.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import social.entity.UserLike;
import social.mapper.UserLikeMapper;
import social.service.IUserLikeService;
import enums.SourceTypeEnum;
import org.springframework.stereotype.Service;
import request.PageParam;
import result.vo.comment.MyLikeResult;

import java.util.List;

/**
 * <p>
 * app用户点赞记录表 服务实现类
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-07-23
 */
@Service
public class UserLikeServiceImpl extends ServiceImpl<UserLikeMapper, UserLike> implements IUserLikeService {

    @Override
    public Page<MyLikeResult> listMyUserLikePage(PageParam pageParam, Long uid) {
        Page<MyLikeResult> page = new Page<>(pageParam.getPageNum(), pageParam.getPageSize());
        List<MyLikeResult> list = baseMapper.listMyUserLikePageByUid(page, uid);

        page.setRecords(list);
        return page;
    }

    @Override
    public Integer isLike(Long uid, SourceTypeEnum typeEnum, Long dataId) {
        return baseMapper.isLike(uid, typeEnum.getType(), dataId);
    }
}
