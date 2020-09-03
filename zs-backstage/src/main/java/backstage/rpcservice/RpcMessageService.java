package backstage.rpcservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import request.user.RpcBulletinMessageParameter;

/**
 * @author 王进
 */
@FeignClient(value = "user")
public interface RpcMessageService {

    /**
     * 往推送表推送消息
     * @param param
     * @return
     */
    @PostMapping("/add/message")
     Boolean addMessage(@RequestBody RpcBulletinMessageParameter param);

    /**
     * 删除推送消息
     * @param bnid
     * @param type
     * @return
     */
    @DeleteMapping("/delete/message/{bnid}")
     Boolean deleteMessage(@PathVariable(value = "bnid")Long bnid, @RequestParam(value ="type" )Long type);
}
