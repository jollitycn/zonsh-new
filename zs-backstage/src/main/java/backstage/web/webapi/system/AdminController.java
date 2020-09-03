package backstage.web.webapi.system;


import backstage.model.dto.admin.ModifyAccountDto;
import backstage.model.dto.admin.RoleGrantUserDto;
import backstage.model.vo.admin.AdminRoleVo;
import backstage.service.IAdminsService;
import backstage.web.webapi.base.BaseController;
import com.baomidou.mybatisplus.plugins.Page;
import dto.LoginAuthDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import wrapper.WrapMapper;
import wrapper.Wrapper;

import javax.validation.Valid;

/**
 * <p>
 * 后台管理员表 前端控制器
 * </p>
 *
 * @author liqun
 * @since 2019-07-09
 */
@Slf4j
@RestController
@RequestMapping(value = "/admin",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "AdminController",tags = {"成员管理"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AdminController extends BaseController {


//    @Autowired
//    private IAdminService iAdminService;

    @Autowired
    private IAdminsService iAdminsService;

//    /**
//     * 管理员分页查询
//     *
//     * @param adminQueryDto
//     * @return the wrapper
//     */
//    @PostMapping(value = "/queryAdminWithPage")
//    @ApiOperation(httpMethod = "POST",value = "管理员分页查询")
//    public Wrapper<Page<AdminRoleVo>> queryAdminWithPage(@ApiParam(name = "adminQueryDto",value = "管理员分页查询dto") @RequestBody AdminQueryDto adminQueryDto){
//        log.info("管理员分页查询 adminQueryDto={}",adminQueryDto);
//        Page<AdminRoleVo> voPage = iAdminsService.queryAdminWithPage(adminQueryDto);
//        return WrapMapper.ok(voPage);
//    }

    /**
     * 管理员分页查询
     *
     * @param adminQueryDto
     * @return the wrapper
     */
    @GetMapping(value = "/adminList")
    @ApiOperation(httpMethod = "GET",value = "管理员分页查询")
    @ApiImplicitParams({ 
		@ApiImplicitParam(name = "pageNum", value = "分页编号", dataType = "int"),
		@ApiImplicitParam(name = "pageSize", value = "分页大小", dataType = "int"),
		@ApiImplicitParam(name = "status", value = "状态（ 0正常  1冻结）", dataType = "int"),
		@ApiImplicitParam(name = "searchKey", value = "搜索参数", dataType = "string")})
    public Result getAdminList(
    		@RequestParam(required = true, value = "pageNum") Integer pageNum,
			@RequestParam(required = true, value = "pageSize") Integer pageSize,
			@RequestParam(required = false, value = "status") Integer status,
    		@RequestParam(required = false, value = "searchKey") String searchKey){
        Page<AdminRoleVo> voPage = iAdminsService.getAdminList(pageNum,pageSize,status,searchKey);
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, 
        		ResultConstans.SUCCESS_MSG,voPage);
    }
    
    
    /**
     * 冻结或者恢复管理员账号
     *
     * @param modifyAccountDto
     * @return the wrapper
     */
    @PostMapping(value = "/modifyAdminAccount")
    @ApiOperation(httpMethod = "POST",value = "冻结/恢复管理员账号")
    public Wrapper<Integer> modifyAdminAccount(@ApiParam(name = "modifyAccountDto",value = "账号操作dto") @RequestBody @Valid ModifyAccountDto modifyAccountDto){
        log.info("操作管理员账号 aid={}",modifyAccountDto);
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        Integer integer = iAdminsService.modifyAdminAccount(modifyAccountDto,loginAuthDto);
        return WrapMapper.ok(integer);
    }
    
    
    /**
     * 新建管理员
     *
     * @param roleGrantUserDto
     * @return the wrapper
     */
    @PostMapping(value = "/addBackstageAdmin")
    @ApiOperation(httpMethod = "POST",value = "新建管理员")
    public Wrapper<Integer> addBackstageAdmin(@ApiParam(name = "roleGrantUserDto",value = "添加后台管理员dto") @RequestBody RoleGrantUserDto roleGrantUserDto){
        log.info("添加后台管理员 roleGrantUserDto={}",roleGrantUserDto);
        LoginAuthDto loginAuthDto = getLoginAuthDto();
        log.info("loginAuthDto={}",loginAuthDto);
        Integer integer = iAdminsService.addBackstageAdmin(roleGrantUserDto,loginAuthDto);
        return WrapMapper.ok(integer);
    }
}
