package backstage.mapper;

import backstage.entity.Admins;
import backstage.model.dto.admin.AdminQueryDto;
import backstage.model.vo.admin.AdminRoleVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 后台管理员表 Mapper 接口
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
public interface AdminsMapper extends BaseMapper<Admins> {

    /**
     * 查询记录
     *
     * @param adminQueryDto
     * @return the list
     */
    List<AdminRoleVo> listAdmin(AdminQueryDto adminQueryDto);

    /**
     * 统计记录数
     *
     * @param adminQueryDto
     * @return the long
     */
    Long countAdmin(AdminQueryDto adminQueryDto);

    /**
     * 查询用户
     *
     * @param loginAccount
     * @return the admins
     */
    Admins queryUser(String loginAccount);

	List<AdminRoleVo> getAdminList(
	        Page<AdminRoleVo> page,
			@Param("status")Integer status,
            @Param("searchKey")String searchKey);
}
