package backstage.interceptor;

import annotation.NoNeedAccessAuthentication;
import backstage.model.vo.admin.ResultLoginVo;
import constant.Constant;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import result.vo.admin.RolePage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import util.RedisAPIUtil;
import util.ThreadLocalMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/13 0013 20:08
 * @description
 */
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    private static final String OPTIONS = "OPTIONS";
    private static final String AUTH_PATH1 = "/login";
    private static final String AUTH_PATH2 = "/oauth";
    private static final String AUTH_PATH3 = "/error";
    private static final String AUTH_PATH4 = "/api";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        log.info("<== preHandle - 权限拦截器.  url={}", uri);
        if (uri.contains(AUTH_PATH1) || uri.contains(AUTH_PATH2) || uri.contains(AUTH_PATH3) || uri.contains(AUTH_PATH4)) {
            log.info("<== preHandle - 配置URL不走认证.  url={}", uri);
            return true;
        }
        log.info("<== preHandle - 调试模式不走认证.  OPTIONS={}", request.getMethod().toUpperCase());

        if (OPTIONS.equalsIgnoreCase(request.getMethod())) {
            log.info("<== preHandle - 调试模式不走认证.  url={}", uri);
            return true;
        }

        if (isHaveAccess(handler)) {
            log.info("<== preHandle - 不需要认证注解不走认证.  token={}");
            return true;
        }

        String header = request.getHeader("Authorization1");
        log.info("header={}",header);
        String token = StringUtils.substringAfter(request.getHeader("Authorization1"), "token ");
        log.info("<== preHandle - 权限拦截器.  token={}", token);
        ResultLoginVo resultLoginVo=JSON.parseObject(RedisAPIUtil.hGet(token),ResultLoginVo.class);

        if (resultLoginVo == null) {
            response.setStatus(227);
            return false;
        }else{
        	ThreadLocalMap.put(Constant.TOKEN_AUTH_TDO, resultLoginVo);
            log.info("<== preHandle - 权限拦截器.  url={}, resultLoginVo={}", uri, resultLoginVo);
        	//处理写权限逻辑
        	String pash=uri.substring(uri.indexOf("/")+1, uri.indexOf("/", 1));
        	log.info("访问路径，pash={}",pash);
        	List<RolePage> roleList=resultLoginVo.getRolePage();
        	for (RolePage role : roleList) {
        		//如果访问路径和权限路径相同
        		if(role.getMenuCode().equals(pash)){
					//如果不是GET请求，需要校验是否有写入权限
					if(!request.getMethod().toUpperCase().equals("GET")){
						if(role.getWrite().equals(1)){
							return true;
						}else{
							response.setCharacterEncoding("UTF-8");
							 PrintWriter out = response.getWriter();
							 String jsonOfRST = "{\"code\":\"205\",\"msg\":\"操作失败，没有此权限,请联系管理员\",\"data\":\"\"}";
							 out.print(jsonOfRST);
							 out.flush();
							return false;
						}
					}
				}
			}
        	
        	

//        	for (RoleMode roleMode : userMenu) {
//        		List<RolePage> rolePage=roleMode.getPageList();
//        		for (RolePage page : rolePage) {
//        			log.info("进入处理写权限逻辑，page={}", page.toString());
//        			if(!request.getMethod().toUpperCase().equals("GET")){
//        				String pash=uri.substring(uri.indexOf("/"), uri.lastIndexOf("/"));
//        				log.info("访问路径，pash={}",pash);
//        				if(!page.getWrite().equals(1)&&page.getMenuCode().equals(pash)){
//        					log.info("无权访问，nikeName={}",resultLoginVo.getLoginAuthDto().getNickName());
//        					return false;
//        				}
//        			}
//				}
//			}
        }
//        log.info("<== preHandle - 权限拦截器.  loginUser={}", resultLoginVo);
//        ThreadLocalMap.put(GlobalConstant.Sys.TOKEN_AUTH_TDO, resultLoginVo);
//        log.info("<== preHandle - 权限拦截器.  url={}, loginUser={}", uri, resultLoginVo);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        if (ex != null) {
            log.error("<== afterCompletion - 解析token失败. ex={}", ex.getMessage(), ex);
            this.handleException(response);
        }
    }

    private void handleException(HttpServletResponse res) throws IOException {
        res.resetBuffer();
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write("{\"code\":100009 ,\"message\" :\"解析token失败\"}");
        res.flushBuffer();

    }

    private boolean isHaveAccess(Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Method method = handlerMethod.getMethod();

        NoNeedAccessAuthentication responseBody = AnnotationUtils.findAnnotation(method, NoNeedAccessAuthentication.class);
        return responseBody != null;
    }





//    public static void main(String[] args) {
//
//    	String uri="/aaa/delTopic/1";
//    	System.out.println(uri.indexOf("/", 1));
//    	String pash=uri.substring(uri.indexOf("/")+1, uri.indexOf("/", 1));
//		System.out.println(pash);
//	}
}
