package backstage.mapper;

import backstage.entity.SystemBulletin;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.ibatis.annotations.Param;
import result.vo.admin.BulletinResult;

import java.util.List;

/**
 * <p>
 * 系统公告 Mapper 接口
 * </p>
 *
 * @author wj
 * @since 2019-07-25
 */
public interface SystemBulletinMapper extends BaseMapper<SystemBulletin> {

    List<BulletinResult> getBulletinList(Page<BulletinResult> page, @Param(value = "searchKey") String searchKey, @Param(value = "status") Integer status);

    void addBulletinViewCount(@Param(value = "bnid") Long bnid);
}
