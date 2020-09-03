package backstage.service;

import backstage.entity.Banner;
import com.baomidou.mybatisplus.service.IService;
import request.activity.BannerParameter;
import result.vo.activity.BannerAndActivityResult;

import java.util.List;

/**
 * <p>
 * banner信息表 服务类
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-06-26
 */
public interface IBannerService extends IService<Banner> {

    /**
     * 获取所有banner详情
     *
     * @return java.util.List&lt;result.vo.activity.BannerAndActivityResult&gt;
     * @author Pan Juncai
     * @date 2019/6/27 17:42
     */
    List<BannerAndActivityResult> listAllBanner();

    /**
     * 创建banner
     *
     * @param bannerParameter banner关联的信息
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/6/27 14:20
     */
    Boolean addBanner(BannerParameter bannerParameter);

    /**
     * 根据banner主键id删除banner
     *
     * @param bid banner主键id
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/6/27 18:00
     */
    Boolean deleteBanner(Long bid);

    /**
     * 通过banner浏览活动时，浏览量+1
     *
     * @param id id值
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/6/27 18:21
     */
    Boolean viewActivity(Long id);

    /**
     * 交换两个banner的排序值
     *
     * @param originBid 原banner的id
     * @param aimBid    目标banner的id
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/6/28 10:17
     */
    Boolean exchangeBannerSort(Long originBid, Long aimBid);

}
