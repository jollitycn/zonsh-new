package backstage.mapper;

import backstage.entity.Activity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import request.activity.QueryActivityPageParameter;
import result.vo.activity.ActivityResult;

import java.util.List;

/**
 * <p>
 * 活动信息表 Mapper 接口
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-06-26
 */
public interface ActivityMapper extends BaseMapper<Activity> {

    /**
     * 根据条件分页查询活动
     *
     * @param page          分页条件（若是手写sql分页必须将page传入mapper接口）
     * @param pageParameter 查询条件
     * @return java.util.List&lt;result.vo.activity.ActivityResult&gt;
     * @author Pan Juncai
     * @date 2019/6/27 15:42
     */
    List<ActivityResult> listActivityPage(Page<ActivityResult> page, QueryActivityPageParameter pageParameter);

    /**
     * 获取数据库中排序字段最大的值
     *
     * @return java.lang.Long
     * @author Pan Juncai
     * @date 2019/6/26 14:50
     */
    Long getMaxSort();

    /**
     * 根据活动id修改活动状态
     *
     * @param aid    要修改的活动id
     * @param status 修改之后的状态
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/6/26 17:37
     */
    Boolean updateStatusByAid(@Param("aid") Long aid, @Param("status") Integer status);

}
