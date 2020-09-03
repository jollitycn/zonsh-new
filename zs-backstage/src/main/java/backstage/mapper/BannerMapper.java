package backstage.mapper;

import backstage.entity.Banner;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.config.BeanPostProcessor;
import result.vo.activity.BannerAndActivityResult;

import java.util.List;

/**
 * <p>
 * banner信息表 Mapper 接口
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-06-26
 */
public interface BannerMapper extends BaseMapper<Banner> {

    /**
     * 获取所有的banner详情
     *
     * @return java.util.List&lt;result.vo.activity.BannerAndActivityResult&gt;
     * @author Pan Juncai
     * @date 2019/6/27 17:44
     */
    List<BannerAndActivityResult> listAllBanner();

    /**
     * 通过banner浏览活动时，浏览量+1
     *
     * @param id id值
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/6/27 18:21
     */
    Boolean viewActivity(@Param("id") Long id);

    /**
     * 获取数据库中排序字段最大的值
     *
     * @return java.lang.Long
     * @author Pan Juncai
     * @date 2019/6/27 14:50
     */
    Long getMaxSort();

    /**
     * 交换两个banner的排序值
     *
     * @param originBid 原banner的id
     * @param aimBid    目标banner的id
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/6/28 10:17
     */
    Boolean exchangeBannerSort(@Param("originBid") Long originBid, @Param("aimBid") Long aimBid);

}
