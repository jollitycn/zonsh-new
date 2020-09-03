package backstage.web.rpc;

import java.util.List;

import annotation.NoNeedAccessAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import backstage.service.IActivityService;
import backstage.service.IBannerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import result.vo.activity.ActivityDetailResult;
import result.vo.activity.BannerAndActivityResult;

/**
 * <p>
 * 活动信息表 前端控制器
 * </p>
 *
 * @author xc
 * @since 2019-06-26
 */
@RestController
public class RpcBackstageController {

	@Autowired
	private IBannerService bannerService;

	@Autowired
	private IActivityService activityService;

	/**
	 * 获取banner列表
	 * @return
	 */
	@NoNeedAccessAuthentication
    @GetMapping("/RpclistAllBanner")
    public List<BannerAndActivityResult> listAllBanner() {
        List<BannerAndActivityResult> list = bannerService.listAllBanner();
        return list;
    }

    /**
     * 查看活动详情
     * @param aid
     * @param type
     * @return
     */
    @NoNeedAccessAuthentication
    @ApiImplicitParam(name = "aid", value = "活动id")
    @GetMapping("/RpcGetDetail")
    public ActivityDetailResult getActivityDetail(
    		@RequestParam(value = "aid") Long aid,
    		@RequestParam(value = "type") Integer type) {
        return activityService.getActivityDetail(aid,type);
    }

}
