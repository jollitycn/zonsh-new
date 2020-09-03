package social.web;

import org.springframework.web.bind.annotation.PathVariable;
import social.entity.UserLike;
import social.rpcservice.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import social.service.IUserLikeService;

/**
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/8/6 16:22
 */
@RestController
public class UserRpcTest {

    @Autowired
    private UserClient userClient;

    @Autowired
    private IUserLikeService userLikeService;

    @RequestMapping("/user/test/{id}")
    public Result testUser(@PathVariable("id") Long id) {
        String hello = userClient.testUser();
        UserLike like = userLikeService.selectById(id);
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE, ResultConstans.SUCCESS_MSG, hello + like);
    }
}
