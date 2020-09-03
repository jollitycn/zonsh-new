package backstage.service.impl;

import backstage.entity.Menus;
import backstage.mapper.MenusMapper;
import backstage.model.dto.menu.UserMenuDto;
import backstage.model.vo.menu.UserMenuVo;
import backstage.model.vo.menu.UserSencondMenuVo;
import backstage.service.IMenusService;
import com.google.common.collect.Lists;
import result.vo.admin.MenuResult;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import util.PublicUtil;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author xc
 * @since 2019-07-12
 */
@Service
public class MenusServiceImpl extends ServiceImpl<MenusMapper, Menus> implements IMenusService {

    @Override
    public List<MenuResult> getMenus(Long uaid) {

        return baseMapper.getMenus(uaid);
    }

    @Override
    public List<UserMenuVo> getUserMenus(Long roleId) {

        //创建返回结果
        UserMenuVo userMenuVo = null;
        List<UserMenuVo> list = Lists.newArrayList();

        //获取该用户显示的一级菜单id集合
        List<Long> menuIds = baseMapper.getUserFirstMenuIds(roleId);

        UserMenuDto userMenuDto = new UserMenuDto();
        userMenuDto.setRoleId(roleId);
        //先获取该用户一级菜单
        if (PublicUtil.isNotEmpty(menuIds)) {
            for (Long menuId : menuIds) {
                userMenuVo = baseMapper.getUserFirstMenus(menuId);
                userMenuDto.setPid(menuId);
                //获取用户的二级菜单
                List<UserSencondMenuVo> userSencondMenuVoList = baseMapper.getUserSecondMenus(userMenuDto);
                userMenuVo.setUserSencondMenuVoList(userSencondMenuVoList);
                list.add(userMenuVo);
            }
        }

        //返回结果
        return list;
    }
}