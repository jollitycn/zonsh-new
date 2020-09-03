package backstage.web.rpc;

import annotation.NoNeedAccessAuthentication;
import backstage.rpcservice.RpcMessageService;
import backstage.service.ISystemBulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 王进
 */
@RestController
public class RpcBulletinController {

    @Autowired
    ISystemBulletinService systemBulletinService;
    @Autowired
    RpcMessageService rpcMessageService;
    /**
     * 公告新增浏览量
     * @param bnid
     * @return
     */
    @NoNeedAccessAuthentication
    @PutMapping("/addBulletin/count/{bnid}")
    public Boolean addBulletinViewCount(@PathVariable(required = true, value = "bnid") Long bnid) {
        return systemBulletinService.addBulletinViewCount(bnid);
    }
}
