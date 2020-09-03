package backstage.service.impl;

import backstage.entity.Activity;
import backstage.entity.Admins;
import backstage.mapper.ActivityMapper;
import backstage.model.constant.activity.ActivityConstant;
import backstage.model.vo.admin.ResultLoginVo;
import backstage.service.IActivityService;
import backstage.service.IAdminsService;
import backstage.service.IBannerService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import constant.Constant;
import dto.LoginAuthDto;
import enums.ActivityTypeEnum;
import enums.ErrorCodeEnum;
import exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import request.activity.ActivityParameter;
import request.activity.QueryActivityPageParameter;
import request.activity.UpdateActivityParameter;
import result.vo.activity.ActivityDetailResult;
import result.vo.activity.ActivityResult;
import util.PublicUtil;
import util.ThreadLocalMap;
import util.ZsUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 活动信息表 服务实现类
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-06-26
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

    private Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);

    @Resource
    private ActivityMapper activityMapper;

    @Autowired
    private IBannerService bannerService;

    @Autowired
    private IAdminsService adminsService;

    @Override
    public Page<ActivityResult> listActivityPage(QueryActivityPageParameter parameter) {
        Page<ActivityResult> page = new Page<>(parameter.getPageNum(), parameter.getPageSize());
        // 若是手写sql分页必须将page传入mapper接口
        List<ActivityResult> list = activityMapper.listActivityPage(page, parameter);
        page.setRecords(list);
        return page;
    }

    @Override
    public Boolean addActivity(ActivityParameter param) {
        Activity activity = new Activity();
        try {
            BeanUtils.copyProperties(param, activity);
            activity.setActivityNumber(ZsUtil.createDateNumberWithPrefix(Constant.UPPER_H));
            activity.setActivityType(ActivityTypeEnum.ONLINE.getType());
            // 若是发布活动则填写发布时间
            if (null != activity.getStatus() && activity.getStatus() == ActivityConstant.STATUS_RELEASE) {
                activity.setReleaseTime(new Date());
            }
            // 查询出排序的最大值
            Long sort = activityMapper.getMaxSort();
            activity.setSort(null == sort ? 1L : sort + 1);
            // 获取当前登录用户信息
            Long userId = getLoginUser().getUaid();
            activity.setCreateBy(userId);
            activity.setUpdateBy(userId);
            activityMapper.insert(activity);
            return true;
        } catch (Exception e) {
            logger.error("Add Activity Error ", e);
        }
        return false;
    }

    @Override
    public Boolean updateActivity(UpdateActivityParameter param) {
        Activity activity = new Activity();
        try {
            BeanUtils.copyProperties(param, activity);

            // 修改之后可重新发布，须填写发布时间
            if (null != activity.getStatus() && activity.getStatus() == ActivityConstant.STATUS_RELEASE) {
                activity.setReleaseTime(new Date());
            }
            // 获取当前登录用户信息
            activity.setUpdateBy(getLoginUser().getUaid());
            activityMapper.updateById(activity);
            return true;
        } catch (Exception e) {
            logger.error("Update Activity Error ", e);
        }
        return false;
    }

    @Override
    public ActivityDetailResult getActivityDetail(Long aid, Integer type) {
        ActivityDetailResult activityDetailResult = new ActivityDetailResult();
        // 查询活动信息
        Activity activity = activityMapper.selectById(aid);
        if (null != activity) {
            BeanUtils.copyProperties(activity, activityDetailResult);
            // 获取修创建人名称
            Admins admins = adminsService.selectById(activity.getCreateBy());
            if (null != admins) {
                activityDetailResult.setCreateUname(admins.getNickName());
            }
        }
        // 判断是否是app端调用获取详情接口，是就浏览量+1
        if (null != type) {
            bannerService.viewActivity(aid);
        }
        return activityDetailResult;
    }

    @Override
    public Boolean downActivity(Long aid) {
        try {
            return activityMapper.updateStatusByAid(aid, ActivityConstant.STATUS_UNRELEASE);
        } catch (Exception e) {
            logger.error("Down Activity Error", e);
        }
        return false;
    }

    @Override
    public Boolean upActivity(Long aid) {
        try {
            return activityMapper.updateStatusByAid(aid, ActivityConstant.STATUS_RELEASE);
        } catch (Exception e) {
            logger.error("Up Activity Error", e);
        }
        return false;
    }

    @Override
    public Boolean deleteActivity(Long aid) {
        try {
            Integer i = activityMapper.deleteById(aid);
            if (null != i && i > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Delete Activity Error ", e);
        }
        return false;
    }

    /**
     * 获取web端登录用户信息e
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
