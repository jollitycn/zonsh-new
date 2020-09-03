package backstage.web.webapi.operate;


import backstage.entity.Activity;
import backstage.model.constant.activity.ActivityConstant;
import backstage.service.IActivityService;
import backstage.service.IBannerService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import request.activity.BannerParameter;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import result.vo.activity.AidAndTitleResult;
import result.vo.activity.BannerAndActivityResult;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * banner信息表 前端控制器
 * </p>
 *
 * @author Pan Juncai
 * @since 2019-06-27
 */
@Api(value = "banner controller", tags = {"banner接口"})
@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private IBannerService bannerService;

    @Autowired
    private IActivityService activityService;

    @ApiOperation("获取banner列表")
    @GetMapping("/listAllBanner")
    public Result listAllBanner() {
        List<BannerAndActivityResult> list = bannerService.listAllBanner();
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, list);
    }

    @ApiOperation("根据类型获取所有活动")
    @ApiImplicitParam(name = "type", value = "类型：0---线上活动")
    @GetMapping("/listActivityByType")
    public List<AidAndTitleResult> listActivityByType(@RequestParam(value = "type") Integer type) {
        List<AidAndTitleResult> resultList = Lists.newArrayList();

        EntityWrapper<Activity> wrapper = new EntityWrapper<>();
        wrapper.eq("activity_type", type);
        //关联已发布的活动
        wrapper.eq("status", ActivityConstant.STATUS_RELEASE);
        List<Activity> list = activityService.selectList(wrapper);

        if (!list.isEmpty()) {
            list.forEach(activity -> {
                AidAndTitleResult aidAndTitleResult = new AidAndTitleResult();
                BeanUtils.copyProperties(activity, aidAndTitleResult);
                resultList.add(aidAndTitleResult);
            });
        }
        return resultList;
    }

    @ApiOperation("创建banner")
    @ApiImplicitParam(name = "BannerParameter", value = "banner信息对象")
    @PostMapping("/addBanner")
    public Result addBanner(@RequestBody @Valid final BannerParameter param) {
        final Boolean isSuccess = bannerService.addBanner(param);
        return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
    }

    @ApiOperation("移除banner")
    @ApiImplicitParam(name = "bid", value = "banner的id")
    @DeleteMapping("/deleteBanner")
    public Result deleteBanner(@RequestParam(value = "bid") Long bid) {
        Boolean isSuccess = bannerService.deleteBanner(bid);
        return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
    }

    @ApiOperation("上移/下移banner")
    @ApiImplicitParams({
            @ApiImplicitParam(required = true, name = "originBid", value = "当前banner的bid"),
            @ApiImplicitParam(required = true, name = "aimBid", value = "目标banner的bid")})
    @PutMapping("/exchangeBannerSort")
    public Result exchangeBannerSort(@RequestParam(value = "originBid") Long originBid
            , @RequestParam(value = "aimBid") Long aimBid) {
        Boolean isSuccess = bannerService.exchangeBannerSort(originBid, aimBid);
        return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_CODE, isSuccess);
    }

}