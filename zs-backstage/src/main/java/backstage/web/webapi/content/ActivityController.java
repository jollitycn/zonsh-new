package backstage.web.webapi.content;


import backstage.service.IActivityService;
import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import request.activity.ActivityParameter;
import request.activity.QueryActivityPageParameter;
import request.activity.UpdateActivityParameter;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import result.vo.activity.ActivityDetailResult;
import result.vo.activity.ActivityResult;

import javax.validation.Valid;

/**
 * <p>
 * 活动信息表 前端控制器
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-06-26
 */
@Api(value = "活动controller", tags = {"活动接口"})
@RestController
@RequestMapping("/activity")
public class ActivityController {


    @Autowired
    private IActivityService activityService;

    @ApiOperation("获取活动列表分页")
    @ApiImplicitParam(name = "QueryActivityPageParameter", value = "查询条件实体")
    @GetMapping("/listActivityPage")
    public Result listActivityPage(@Valid final QueryActivityPageParameter param) {
        Page<ActivityResult> page = activityService.listActivityPage(param);
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, page);
    }

    @ApiOperation("创建活动")
    @ApiImplicitParam(name = "ActivityParameter", value = "活动信息对象")
    @PostMapping("/add/activity")
    public Result addActivity(@RequestBody @Valid final ActivityParameter param) {
        final Boolean isSuccess = activityService.addActivity(param);
        return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
    }

    @ApiOperation("修改活动")
    @ApiImplicitParam(name = "UpdateActivityParameter", value = "修改活动信息对象")
    @PutMapping("/update/activity")
    public Result updateActivity(@RequestBody @Valid final UpdateActivityParameter param) {
        final Boolean isSuccess = activityService.updateActivity(param);
        return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
    }

    @ApiOperation("查看活动详情")
    @ApiImplicitParam(name = "aid", value = "活动id", required = true)
    @GetMapping("/getDetail/activity")
    public ActivityDetailResult getActivityDetail(@RequestParam(value = "aid") Long aid) {
        return activityService.getActivityDetail(aid, null);
    }

    @ApiOperation("下架活动")
    @ApiImplicitParam(name = "aid", value = "活动id")
    @PutMapping("/downActivity")
    public Result downActivity(@RequestParam(value = "aid") Long aid) {
        Boolean isSuccess = activityService.downActivity(aid);
        return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
    }

    @ApiOperation("上架活动")
    @ApiImplicitParam(name = "aid", value = "活动id")
    @PutMapping("/upActivity")
    public Result upActivity(@RequestParam(value = "aid") Long aid) {
        Boolean isSuccess = activityService.upActivity(aid);
        return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
    }

    @ApiOperation("删除活动")
    @ApiImplicitParam(name = "aid", value = "活动id")
    @DeleteMapping("/deleteActivity")
    public Result deleteActivity(@RequestParam(value = "aid") Long aid) {
        Boolean isSuccess = activityService.deleteActivity(aid);
        return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
    }

}
