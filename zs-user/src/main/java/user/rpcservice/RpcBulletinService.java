package user.rpcservice;

import annotation.NoNeedAccessAuthentication;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author 王进
 */
@FeignClient(value = "backstage")
public interface RpcBulletinService {

    /**
     * 编辑公告浏览量
     * @param bnid
     * @return
     */
    @PutMapping("/addBulletin/count/{bnid}")
    Boolean addBulletinViewCount(@PathVariable(required = true, value = "bnid") Long bnid);
}
