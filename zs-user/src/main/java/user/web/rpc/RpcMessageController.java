package user.web.rpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import request.user.RpcBulletinMessageParameter;
import user.service.IMessageService;

/**
 * @author 王进
 */
@RestController
public class RpcMessageController {

    @Autowired
    private IMessageService messageService;

    @PostMapping("/add/message")
    public Boolean addMessage(@RequestBody RpcBulletinMessageParameter param){
        return  messageService.addMessage(param);
    }

    @DeleteMapping("/delete/message/{bnid}")
    public Boolean deleteMessage(@PathVariable(value = "bnid")Long bnid,@RequestParam(value ="type" )Long type){

        return messageService.deleteBulletinMessage(bnid, type);
    }
}
