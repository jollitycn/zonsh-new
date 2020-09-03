package social.rpcservice;

import api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/8/6 16:21
 */
 @FeignClient("user")
public interface UserClient extends UserApi {

}
