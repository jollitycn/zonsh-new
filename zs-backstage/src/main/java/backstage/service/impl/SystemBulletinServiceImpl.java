package backstage.service.impl;

import backstage.entity.SystemBulletin;
import backstage.mapper.SystemBulletinMapper;
import backstage.service.ISystemBulletinService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.base.Strings;
import org.springframework.stereotype.Service;
import request.BulletinParameter;
import request.CancelBulletinParameter;
import result.vo.admin.BulletinResult;
import result.vo.comment.AnswerReportResult;
import util.ZsUtil;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 系统公告 服务实现类
 * </p>
 *
 * @author wj
 * @since 2019-07-25
 */
@Service
public class SystemBulletinServiceImpl extends ServiceImpl<SystemBulletinMapper, SystemBulletin> implements ISystemBulletinService {


    @Override
    public SystemBulletin addBulletin(BulletinParameter param, Long uid) {
        try {
            SystemBulletin bulletin = new SystemBulletin();
            bulletin.setCreateId(uid!=null?uid:0L);
            bulletin.setBulletinTitle(param.getBulletinTitle());
            bulletin.setBulletinContent(param.getBulletinContent());
            bulletin.setStatus(param.getStatus());
            if (param.getStatus() == 0) {
                bulletin.setReleaseTime(new Date());
            }
            Integer bid = baseMapper.insert(bulletin);

            if (bid!=null&& bid>0) {
                bulletin.setNumber("A"+ZsUtil.fillSymbolToNumber(bulletin.getBnid(), 8));
                baseMapper.updateById(bulletin);
            }
            return bulletin;
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public Page<BulletinResult> getBulletinList(Integer pageNum, Integer pageSize, String content, Integer status) {
        String search = null;
        if (!Strings.isNullOrEmpty(content)) {
            search = "%" + content + "%";
        }
        Page<BulletinResult> page = new Page<>(pageNum, pageSize);
        List<BulletinResult> answerReportList = baseMapper.getBulletinList(page, search, status);
        return page.setRecords(answerReportList);
    }

    @Override
    public SystemBulletin cancelOrPublishBulletin(CancelBulletinParameter param) {
        //1.编辑公告表，将状态修改为草稿
        SystemBulletin bulletin = baseMapper.selectById(param.getBnid());
        if (bulletin != null) {
            bulletin.setStatus(param.getStatus());
            if (param.getStatus() == 0) {
                bulletin.setReleaseTime(new Date());
            }
            baseMapper.updateById(bulletin);
            return bulletin;
        }
        return null;
    }

    @Override
    public Boolean deleteBulletin(Long bnid) {
        SystemBulletin bulletin = baseMapper.selectById(bnid);
        if (bulletin != null) {
            Integer isSuccess = baseMapper.deleteById(bnid);
            if (isSuccess != null && isSuccess > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean addBulletinViewCount(Long bnid) {
        try {
            baseMapper.addBulletinViewCount(bnid);
            return true;
        }catch (Exception e){}
        return false;
    }
}
