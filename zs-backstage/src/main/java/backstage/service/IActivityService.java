package backstage.service;

import backstage.entity.Activity;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import request.activity.ActivityParameter;
import request.activity.QueryActivityPageParameter;
import request.activity.UpdateActivityParameter;
import result.vo.activity.ActivityDetailResult;
import result.vo.activity.ActivityResult;

/**
 * <p>
 * 活动信息表 服务类
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-06-26
 */
public interface IActivityService extends IService<Activity> {

    /**
     * 分页查询活动列表
     *
     * @param parameter 查询条件
     * @return com.baomidou.mybatisplus.plugins.Page&lt;result.vo.activity.ActivityResult&gt;
     * @author Pan Juncai
     * @date 2019/6/27 15:36
     */
    Page<ActivityResult> listActivityPage(QueryActivityPageParameter parameter);

    /**
     * 新增单个的活动
     *
     * @param param 添加参数
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/6/26 13:57
     */
    Boolean addActivity(ActivityParameter param);

    /**
     * 根据主键id修改活动标题和内容
     *
     * @param param 修改的信息
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/6/26 15:53
     */
    Boolean updateActivity(UpdateActivityParameter param);

    /**
     * 根据活动的主键id获取活动详情
     *
     * @param aid  要查询的活动主键id
     * @param type app端调用标识，查看详情自动浏览+1
     * @return result.vo.activity.ActivityDetailResult
     * @author Pan Juncai
     * @date 2019/6/26 16:24
     */
    ActivityDetailResult getActivityDetail(Long aid, Integer type);

    /**
     * 根据活动id下架活动（修改状态）
     *
     * @param aid 要下架的活动id
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/6/26 17:27
     */
    Boolean downActivity(Long aid);

    /**
     * 根据活动id上架活动（修改状态）
     *
     * @param aid 要上架的活动id
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/6/26 17:30
     */
    Boolean upActivity(Long aid);

    /**
     * 根据活动id删除活动
     *
     * @param aid 要删除的id
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/6/26 18:16
     */
    Boolean deleteActivity(Long aid);

}
