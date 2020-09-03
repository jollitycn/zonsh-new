package base;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import com.google.common.base.Strings;
import result.Result;
import result.ResultConstans;
import result.ResultFactory;
import util.jwt.JwtHelper;

/**
 * 基础controller
 *
 * @author Pan Juncai
 * @version 1.0
 * @date 2019/8/7 11:37
 */
public class BaseController extends Loggable {

    /**
     * 获取移动端登录用户的uid
     *
     * @param request 请求
     * @return java.lang.Long
     * @author Pan Juncai
     * @date 2019/8/7 11:37
     */
    protected Long getAppLoginUserUid(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (!Strings.isNullOrEmpty(token) && !"null".equals(token)) {
            try {
                //这里是移动端传过来的token信息进行解密得到的数据，除了uid，其他信息不能保证是最新的
                Map<String, String> userInfo = JwtHelper.verifyToken(token);
                Long uid = Long.valueOf(userInfo.get("uid"));
                return uid;
            } catch (UnsupportedEncodingException e) {
                //token验证失败
                getLogger().error("token验证失败:{}", token, e);
                e.printStackTrace();
            }
        }
        return 0L;
    }

    /**
     * 操作成功
     *
     * @param
     * @return
     */
    protected Result success() {
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                ResultConstans.SUCCESS_MSG);
    }


    /**
     * 操作失败
     *
     * @param request
     * @return
     */
    protected Result error() {
        return ResultFactory.generateResult(ResultConstans.ERROR_CODE,
                ResultConstans.ERROR_MSG);
    }

    /**
     * 返回数据
     *
     * @param request
     * @return
     */
    protected Result resultData(Object obj) {
        return ResultFactory.generateResult(ResultConstans.SUCCESS_CODE,
                ResultConstans.SUCCESS_MSG, obj);
    }

//	
//	/**
//	 * 自定义code返回
//	 * @param request
//	 * @return
//	 */
//	protected Result resultCode(String code,String msg){
//		return ResultFactory.generateResult(code,
//				msg);
//    }

}
