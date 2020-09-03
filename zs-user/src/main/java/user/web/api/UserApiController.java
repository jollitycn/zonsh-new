package user.web.api;

import api.UserApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/8/6 16:17
 */
 @RestController
public class UserApiController implements UserApi {
    @Override
    public String testUser() {
        return "hello man！！！";
    }
}
