package backstage.web.webapi.system;


import backstage.entity.SystemBulletin;
import backstage.rpcservice.RpcMessageService;
import backstage.rpcservice.RpcUserService;
import backstage.service.ISystemBulletinService;
import base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import request.BulletinParameter;
import request.CancelBulletinParameter;
import request.user.RpcBulletinMessageParameter;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 系统公告 前端控制器
 * </p>
 *
 * @author wj
 * @since 2019-07-25
 */
@RestController
@RequestMapping("/systemBulletin")
@Api(value = "SystemBulletinController", tags = {"系统公告管理接口"})
public class SystemBulletinController extends BaseController {

    @Autowired
    ISystemBulletinService systemBulletinService;

    @Autowired
    protected RpcUserService rpcUserService;

    @Autowired
    RpcMessageService rpcMessageService;

    @PostMapping("/add/bulletin")
    @ApiOperation(value = "创建系统公告")
    public Result addBulletin(@RequestBody BulletinParameter param, HttpServletRequest request) {
        // 如果是已登录用户,判断是否回答过该问题

        Long uid = getAppLoginUserUid(request);
        SystemBulletin bulletin = systemBulletinService.addBulletin(param, uid);
        if (bulletin != null) {
            pushBulletinMessage(bulletin);
        }
        return ResultFactory.generateResult(bulletin != null ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                bulletin != null ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_MSG, bulletin);
    }

    @GetMapping("/bulletin/list")
    @ApiOperation(value = "获取公告列表")
    public Result getBulletinList(
            @RequestParam(required = true, value = "pageNum") Integer pageNum,
            @RequestParam(required = true, value = "pageSize") Integer pageSize,
            @RequestParam(required = false, value = "content") String content,
            @RequestParam(required = true, value = "status") Integer status) {
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                ResultConstans.SUCCESS_MSG, systemBulletinService.getBulletinList(pageNum, pageSize, content, status));

    }

    @ApiOperation(value = "撤销或发布系统公告")
    @PutMapping("/cancel/publish/bulletin")
    public Result cancelOrPublishBulletin(@RequestBody CancelBulletinParameter param) {
        SystemBulletin bulletin = systemBulletinService.cancelOrPublishBulletin(param);
        if (bulletin != null) {
            //删除推送消息
            if (param.getStatus() == 1) {
                rpcMessageService.deleteMessage(bulletin.getBnid(), 1L);
            } else {
                //push消息
                pushBulletinMessage(bulletin);
            }
        }
        return ResultFactory.generateResult(bulletin != null ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                bulletin != null ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_MSG, bulletin);
    }

    @ApiOperation(value = "删除系统公告")
    @DeleteMapping("/cancel/bulletin/{bnid}")
    public Result deleteBulletin(@PathVariable(value = "bnid") Long bnid
    ) {
        Boolean isSuccess = systemBulletinService.deleteBulletin(bnid);
        if (isSuccess) {
            //删除推送消息
            rpcMessageService.deleteMessage(bnid, 1L);
        }
        return ResultFactory.generateResult(isSuccess ? ResultConstans.SUCCESS_CODE : ResultConstans.ERROR_CODE,
                isSuccess ? ResultConstans.SUCCESS_MSG : ResultConstans.ERROR_MSG, isSuccess);
    }

    /**
     * 往推送表中插入消息
     *
     * @param bulletin
     */
    private void pushBulletinMessage(SystemBulletin bulletin) {
        RpcBulletinMessageParameter bulletinParam = new RpcBulletinMessageParameter();
        bulletinParam.setType(1);
        bulletinParam.setMessageTitle(bulletin.getBulletinTitle());
        bulletinParam.setMessageContent(bulletin.getBulletinContent());
        bulletinParam.setRelationId(bulletin.getBnid());
        bulletinParam.setCreateUid(bulletin.getCreateId());
        bulletinParam.setCreateUidType(1);
        rpcMessageService.addMessage(bulletinParam);
    }


}
