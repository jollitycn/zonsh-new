package social.rpcservice;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import request.RpcAnswerParameter;
import result.vo.LoginUser;
import result.vo.UserResult;

/**
 * @author wangJin
 *
 * @date 2019年6月11日 下午2:56:23
 *
 */
@FeignClient(value = "user")
public interface RpcReplyUserService {

  @RequestMapping(value = "/reply/user/info", method = RequestMethod.POST)
  List<RpcAnswerParameter> getReplyUserInfo(
    @RequestBody  RpcAnswerParameter param);

  @RequestMapping(value = "/user/uid", method = RequestMethod.GET)
  UserResult getUserInfoByUid(@RequestParam(value="uid")Long uid);

  @RequestMapping(value = "/getLoginUser", method = RequestMethod.POST)
  LoginUser getLoginUser(@RequestParam("token") String token);
    
  	
}
