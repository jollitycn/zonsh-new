package backstage.web.webapi.system;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import backstage.web.webapi.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import backstage.entity.Roles;
import backstage.service.IMenusService;
import backstage.service.IRolesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import request.admin.RoleParam;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import result.vo.admin.MenuResult;
import result.vo.admin.RolesDeatilResult;


/**
 * <p>
 * 后台管理员表 前端控制器
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
@RestController
@RequestMapping("/role")
@Api(value = "RoleController", tags = {"权限管理接口"})
@Slf4j
public class RoleController extends BaseController {

	@Autowired
	private IMenusService menusService;
	
	@Autowired
	private IRolesService rolesService;
	
//	@Autowired
//	private IAdminsService adminsService;
	
	/**
     * 获取系统菜单
     *
     * @param mid
     */
    @GetMapping(value = "/getMenu")
    @ApiOperation(value = "获取系统菜单")
    public Result getMenus(HttpServletRequest request){
        Long uaid=1L;

    	List<MenuResult> result=menusService.getMenus(uaid);
       return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, 
    		   ResultConstans.SUCCESS_MSG,result);
    }
	
    /**
     * 获取角色列表
     *
     * @param
     */
    @GetMapping(value = "/getRoleList")
    @ApiOperation(value = "获取角色列表")
    public Result getRoleList(){
    	EntityWrapper<Roles> wrapper=new EntityWrapper<>();
    	List<Roles> result=rolesService.selectList(wrapper);
       return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, 
    		   ResultConstans.SUCCESS_MSG,result);
    }
	
    /**
     * 获取角色权限详情
     *
     * @param mid
     */
    @GetMapping(value = "/getRoleDetail")
    @ApiOperation(value = "获取角色权限详情")
    @ApiImplicitParam(name = "rid", value = "角色id")
    public Result getRoleDetail(Long rid){
    	List<RolesDeatilResult> result=rolesService.getRoleDetail(rid);
       return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, 
    		   ResultConstans.SUCCESS_MSG,result);
    }
    
    /**
     * 更改角色权限
     * @param roleParam
     * @return
     */
    @PostMapping(value = "/changeRoleDetail")
    @ApiOperation(value = "更改角色权限")
    public Result changeRoleDetail(@RequestBody RoleParam roleParam){
    	Boolean boole=rolesService.changeRoleDetail(roleParam);
    	if(boole){
    		return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, 
    	     		   ResultConstans.SUCCESS_MSG);
    	}else{
    		return ResultFactory.generateResult(ResultConstans.ERROR_CODE, 
    	     		   ResultConstans.ERROR_MSG);
    	}
    	
    }
    
    
//    /**
//     * 管理员分页查询
//     *
//     * @param adminQueryDto
//     * @return the wrapper
//     */
//    @PostMapping(value = "/queryAdminWithPage")
//    @ApiOperation(httpMethod = "POST",value = "管理员分页查询")
//    public Wrapper<Page<AdminRoleVo>> queryAdminWithPage(
//    		@ApiParam(name = "adminQueryDto",value = "管理员分页查询dto") @RequestBody AdminQueryDto adminQueryDto){
//        log.info("管理员分页查询 adminQueryDto={}",adminQueryDto);
//        Page<AdminRoleVo> voPage = adminsService.queryAdminWithPage(adminQueryDto);
//        return WrapMapper.ok(voPage);
//    }

//    /**
//     * 恢复或者冻结账号
//     *
//     * @param modifyAccountDto
//     * @return the wrapper
//     */
//    @PostMapping(value = "/modifyAdminAccount")
//    @ApiOperation(httpMethod = "POST",value = "恢复或者冻结账号")
//    public Wrapper<Integer> modifyAdminAccount(@ApiParam(name = "modifyAccountDto",value = "账号操作dto") @RequestBody @Valid ModifyAccountDto modifyAccountDto){
//        log.info("操作管理员账号 aid={}",modifyAccountDto);
//        LoginAuthDto loginAuthDto = getLoginAuthDto();
//        Integer integer = adminsService.modifyAdminAccount(modifyAccountDto,loginAuthDto);
//        return WrapMapper.ok(integer);
//    }
    
    
//	  /**
//	  * 添加后台管理员
//	  *
//	  * @param roleGrantUserDto
//	  * @return the wrapper
//	  */
//	 @PostMapping(value = "/addBackstageAdmin")
//	 @ApiOperation(httpMethod = "POST",value = "添加后台管理员")
//	 public Wrapper<Integer> addBackstageAdmin(@ApiParam(name = "roleGrantUserDto",value = "添加后台管理员dto") @RequestBody RoleGrantUserDto roleGrantUserDto){
//	     log.info("添加后台管理员 roleGrantUserDto={}",roleGrantUserDto);
//	     LoginAuthDto loginAuthDto = getLoginAuthDto();
//	     log.info("loginAuthDto={}",loginAuthDto);
//	     Integer integer = adminsService.addBackstageAdmin(roleGrantUserDto,loginAuthDto);
//	     return WrapMapper.ok(integer);
//	 }
}
