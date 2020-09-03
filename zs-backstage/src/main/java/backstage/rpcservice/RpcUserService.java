package backstage.rpcservice;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.baomidou.mybatisplus.plugins.Page;

import feign.Headers;
import request.TopicParameter;
import result.vo.InvitationUserResult;
import result.vo.LoginUser;
import result.vo.UserResult;
import result.vo.WebUserResult;

/**
 * rpc远程调用用户模块接口
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/6/26 16:44
 */
@FeignClient(value = "user")
public interface RpcUserService {

  @GetMapping(value = "/user/uid")
  UserResult getUserInfoByUid(@RequestParam(value = "uid") Long uid);

  @PostMapping(value = "/getLoginUser")
  LoginUser getLoginUser(@RequestParam("token") String token);

  @PostMapping(value = "/web/addInvitation")
  @Headers("Content-Type: application/json")
  Boolean insertTopicInvite(@RequestBody TopicParameter param);

  @GetMapping(value = "/topicUserList")
  Page<InvitationUserResult> getTopicUserList(
      @RequestParam("pageNum") Integer pageNum,
      @RequestParam("pageSize") Integer pageSize,
      @RequestParam("searchKey") String searchKey,
      @RequestParam("tid") Long tid);

  @GetMapping("/userList")
  Page<WebUserResult> getUserList(
      @RequestParam(required = true, value = "pageNum") Integer pageNum,
      @RequestParam(required = true, value = "pageSize") Integer pageSize,
      @RequestParam(required = true, value = "status") Integer status,
      @RequestParam(required = false, value = "startTime") String startTime,
      @RequestParam(required = false, value = "endTime") String endTime,
      @RequestParam(required = false, value = "searchKey") String searchKey);

  @PutMapping("/changeUserStatus")
  Boolean updateUserStatus(
      @RequestParam(required = true, value = "uid") Long uid,
      @RequestParam(required = true, value = "status") Integer status);

}
