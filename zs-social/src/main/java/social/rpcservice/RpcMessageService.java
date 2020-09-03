package social.rpcservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import request.user.RpcBulletinMessageParameter;

/**
 * 消息远程调用
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/7/29 13:46
 */
@FeignClient(value = "user")
public interface RpcMessageService {

    /**
     * 新增消息，根据类型填入内容
     *
     * @param param 参数
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/29 13:47
     */
    @PostMapping("/add/message")
    Boolean addMessage(@RequestBody RpcBulletinMessageParameter param);

    /**
     * 删除消息
     *
     * @param bnid 关联id 可能包含用户id 话题id 活动id 评论id 公告id 反馈id，具体根据type判断
     * @param type 类型  1小助手 2回答邀请 3互动  4关注 5意见反馈
     * @return java.lang.Boolean
     * @author Pan Juncai
     * @date 2019/7/29 13:49
     */
    @DeleteMapping("/delete/message/{bnid}")
    Boolean deleteMessage(@PathVariable(value = "bnid") Long bnid, @RequestParam(value = "type") Long type);
}
