package backstage.service.impl;

import backstage.entity.Banner;
import backstage.mapper.BannerMapper;
import backstage.model.vo.admin.ResultLoginVo;
import backstage.service.IBannerService;
import constant.Constant;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import dto.LoginAuthDto;
import enums.ErrorCodeEnum;
import exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import request.activity.BannerParameter;
import result.vo.activity.BannerAndActivityResult;
import util.PublicUtil;
import util.ThreadLocalMap;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * banner信息表 服务实现类
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-06-26
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {

    private Logger logger = LoggerFactory.getLogger(BannerServiceImpl.class);

    @Resource
    private BannerMapper bannerMapper;

    @Override
    public List<BannerAndActivityResult> listAllBanner() {
        return bannerMapper.listAllBanner();
    }

    @Override
    public Boolean addBanner(BannerParameter bannerParameter) {
        Banner banner = new Banner();
        try {
            BeanUtils.copyProperties(bannerParameter, banner);

            // 查询出排序的最大值
            Long sort = bannerMapper.getMaxSort();
            banner.setSort(null == sort ? 1L : sort + 1);
            // 获取登录用户信息
            LoginAuthDto loginAdmin = getLoginUser();
            banner.setCreateBy(loginAdmin.getUaid());
            banner.setUpdateBy(loginAdmin.getUaid());
            bannerMapper.insert(banner);
            return true;
        } catch (Exception e) {
            logger.error("Add Banner Error ", e);
        }
        return false;
    }

    @Override
    public Boolean deleteBanner(Long bid) {
        try {
            bannerMapper.deleteById(bid);
            return true;
        }catch (Exception e) {
            logger.error("Delete Banner Error ", e);
        }
        return false;
    }

    @Override
    public Boolean viewActivity(Long id) {
        return bannerMapper.viewActivity(id);
    }

    @Override
    public Boolean exchangeBannerSort(Long originBid, Long aimBid) {
        return bannerMapper.exchangeBannerSort(originBid, aimBid);
    }

    /**
     * 获取web端登录用户信息
     *
     * @return dto.LoginAuthDto
     * @author Pan Juncai
     * @date 2019/7/18 16:59
     */
    private LoginAuthDto getLoginUser() {
        ResultLoginVo resultLoginVo = (ResultLoginVo) ThreadLocalMap.get(Constant.TOKEN_AUTH_TDO);
        LoginAuthDto loginAuthDto = resultLoginVo.getLoginAuthDto();
        if (PublicUtil.isEmpty(loginAuthDto)) {
            throw new BusinessException(ErrorCodeEnum.AUTH10010009);
        }
        return loginAuthDto;
    }
}
