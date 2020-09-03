package backstage.service;

import backstage.entity.Admins;
import backstage.model.dto.admin.AdminQueryDto;
import backstage.model.dto.admin.ModifyAccountDto;
import backstage.model.dto.admin.RoleGrantUserDto;
import backstage.model.vo.admin.AdminRoleVo;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import dto.LoginAuthDto;

/**
 * <p>
 * 后台管理员表 服务类
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
public interface IAdminsService extends IService<Admins> {

    /**
     * 管理员分页查询
     *
     * @param adminQueryDto
     * @return the page
     */
    Page<AdminRoleVo> queryAdminWithPage(AdminQueryDto adminQueryDto);

    /**
     * 操作管理员账号
     *
     * @param modifyAccountDto
     * @param loginAuthDto
     * @return the integer
     */
    Integer modifyAdminAccount(ModifyAccountDto modifyAccountDto, LoginAuthDto loginAuthDto);

//    /**
//     * 恢复管理员账号
//     *
//     * @param modifyAccountDto
//     * @return the integer
//     */
//    Integer restoreAdminAccount(ModifyAccountDto modifyAccountDto);


    /**
     * 添加后台管理员
     *
     * @param roleGrantUserDto
     * @param loginAuthDto
     * @return the integer
     */
    Integer addBackstageAdmin(RoleGrantUserDto roleGrantUserDto, LoginAuthDto loginAuthDto);

	/**
	 * 获取管理员列表
	 * @param pageNum
	 * @param pageSize
	 * @param status
	 * @return
	 */
	Page<AdminRoleVo> getAdminList(Integer pageNum, Integer pageSize, Integer status,String searchKey);
}
