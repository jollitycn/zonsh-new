//package backstage.web.webapi.system;
//
//import backstage.model.dto.admin.RoleGrantUserDto;
//import backstage.service.IAdminsService;
//import backstage.web.webapi.base.BaseController;
//import dto.LoginAuthDto;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//import wrapper.WrapMapper;
//import wrapper.Wrapper;
//
//import javax.validation.Valid;
//
///**
// * @author liqun
// * @version 1.0
// * @date 2019/7/9 15:37
// * @description 角色授权管理(后台管理员)
// */
//@Slf4j
//@RestController
//@RequestMapping(value = "/role-admin",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//@Api(value = "角色授权controller", tags = {"角色授权操作接口"},produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//public class RoleBindUserController extends BaseController {
//
////    @Autowired
////    private IAdminService iAdminService;
//
//    @Autowired
//    private IAdminsService iAdminsService;
//
//    /**
//     * 新建管理员
//     *
//     * @param roleGrantUserDto
//     * @return the wrapper
//     */
//    @GetMapping(value = "/addBackstageAdmin")
//    @ApiOperation(httpMethod = "GET",value = "新建管理员")
//    public Wrapper<Integer> addBackstageAdmin(@ApiParam(name = "roleGrantUserDto",value = "添加后台管理员dto") @Valid RoleGrantUserDto roleGrantUserDto){
//        log.info("添加后台管理员 roleGrantUserDto={}",roleGrantUserDto);
//        LoginAuthDto loginAuthDto = getLoginAuthDto();
//        log.info("loginAuthDto={}",loginAuthDto);
//        Integer integer = iAdminsService.addBackstageAdmin(roleGrantUserDto,loginAuthDto);
//        return WrapMapper.ok(integer);
//    }
//}
