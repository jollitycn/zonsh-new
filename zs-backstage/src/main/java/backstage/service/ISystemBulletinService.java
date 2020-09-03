package backstage.service;

import backstage.entity.SystemBulletin;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import request.BulletinParameter;
import request.CancelBulletinParameter;
import result.vo.admin.BulletinResult;

/**
 * <p>
 * 系统公告 服务类
 * </p>
 *
 * @author wj
 * @since 2019-07-25
 */
public interface ISystemBulletinService extends IService<SystemBulletin> {

    /**
     * 添加系统公告
     *
     * @param param
     * @param uid
     * @return SystemBulletin
     */
    SystemBulletin addBulletin(BulletinParameter param, Long uid);

    /**
     * 获取公告列表
     * @param pageNum 分页数
     * @param pageSize 分页大小
     * @param content 公告内容
     * @param status 状态
     * @return BulletinResult
     */
    Page<BulletinResult> getBulletinList(Integer pageNum, Integer pageSize, String content, Integer status);


    /**
     * 撤销或发布公告
     * @param param
     * @return
     */
    SystemBulletin cancelOrPublishBulletin( CancelBulletinParameter param);


    /**
     * 删除公告
     * @param bnid 公告id
     * @return Boolean
     */
    Boolean deleteBulletin(Long bnid);

    /**
     * 新增浏览量
     * @param bnid
     * @return
     */
    Boolean addBulletinViewCount(Long bnid);
}
