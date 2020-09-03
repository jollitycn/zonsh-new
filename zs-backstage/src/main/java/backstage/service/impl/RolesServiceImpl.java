package backstage.service.impl;

import backstage.entity.Roles;
import backstage.entity.RolesDetail;
import backstage.mapper.RolesDetailMapper;
import backstage.mapper.RolesMapper;
import backstage.service.IRolesService;
import request.admin.RoleDetailParam;
import request.admin.RoleParam;
import result.vo.admin.RoleMode;
import result.vo.admin.RolePage;
import result.vo.admin.RolesDeatilResult;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
@Service
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements IRolesService {

	@Autowired
    private RolesDetailMapper rolesDetailMapper;
	
	
	@Override
	public List<RolesDeatilResult> getRoleDetail(Long rid) {
		return baseMapper.getRoleDetail(rid);
	}

	@Override
	public Boolean changeRoleDetail(RoleParam roleParam) {
		try {
			//更改对应权限
			List<RoleDetailParam> roleDetailList=roleParam.getRoleDetailList();
			for (RoleDetailParam rdParam : roleDetailList) {
				RolesDetail updateDetail=new RolesDetail();
				updateDetail.setWrite(rdParam.getWrite());
				updateDetail.setRead(rdParam.getRead());
				EntityWrapper<RolesDetail> wrapper=new EntityWrapper<>();
				wrapper.eq("rdid", rdParam.getRdid());
				rolesDetailMapper.update(updateDetail, wrapper);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<RoleMode> getUserMenus(Long roleId) {
		
		//查询角色拥有的二级菜单读权限
		return baseMapper.getUserMenus(roleId);
	}

	@Override
	public List<RolePage> getRole(Long roleId) {
		return baseMapper.getRole(roleId);
	}

	
	
}
