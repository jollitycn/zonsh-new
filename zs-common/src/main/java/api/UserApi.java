package api;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/8/6 16:14
 */
public interface UserApi {

    @RequestMapping("/user/test")
    String testUser();
}
