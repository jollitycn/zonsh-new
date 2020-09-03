//package interceptor;
//
//import annotation.NoNeedAccessAuthentication;
//import com.alibaba.fastjson.JSON;
//import constant.GlobalConstant;
//import dto.LoginAuthDto;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.core.annotation.AnnotationUtils;
//import org.springframework.http.HttpHeaders;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import util.RedisAPIUtil;
//import util.ThreadLocalMap;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.lang.reflect.Method;
//
///**
// * @author liqun
// * @version 1.0
// * @date 2019/7/13 0013 20:08
// * @description
// */
//@Slf4j
//public class TokenInterceptor implements HandlerInterceptor {
//
//    private static final String OPTIONS = "OPTIONS";
//    private static final String AUTH_PATH1 = "/login";
//    private static final String AUTH_PATH2 = "/oauth";
//    private static final String AUTH_PATH3 = "/error";
//    private static final String AUTH_PATH4 = "/api";
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String uri = request.getRequestURI();
//        log.info("<== preHandle - 权限拦截器.  url={}", uri);
//        if (uri.contains(AUTH_PATH1) || uri.contains(AUTH_PATH2) || uri.contains(AUTH_PATH3) || uri.contains(AUTH_PATH4)) {
//            log.info("<== preHandle - 配置URL不走认证.  url={}", uri);
//            return true;
//        }
//        log.info("<== preHandle - 调试模式不走认证.  OPTIONS={}", request.getMethod().toUpperCase());
//
//        if (OPTIONS.equalsIgnoreCase(request.getMethod())) {
//            log.info("<== preHandle - 调试模式不走认证.  url={}", uri);
//            return true;
//        }
//
//        if (isHaveAccess(handler)) {
//            log.info("<== preHandle - 不需要认证注解不走认证.  token={}");
//            return true;
//        }
//        String header = request.getHeader("Authorization1");
//        log.info("header={}",header);
//        String token = StringUtils.substringAfter(request.getHeader("Authorization1"), "token ");
//        log.info("<== preHandle - 权限拦截器.  token={}", token);
//        LoginAuthDto loginUser = JSON.parseObject(RedisAPIUtil.hGet(token),LoginAuthDto.class);
//        if (loginUser == null) {
//            log.error("获取用户信息失败, 不允许操作");
//            return false;
//        }
//        log.info("<== preHandle - 权限拦截器.  loginUser={}", loginUser);
//        ThreadLocalMap.put(GlobalConstant.Sys.TOKEN_AUTH_TDO, loginUser);
//        log.info("<== preHandle - 权限拦截器.  url={}, loginUser={}", uri, loginUser);
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//        if (ex != null) {
//            log.error("<== afterCompletion - 解析token失败. ex={}", ex.getMessage(), ex);
//            this.handleException(response);
//        }
//    }
//
//    private void handleException(HttpServletResponse res) throws IOException {
//        res.resetBuffer();
//        res.setHeader("Access-Control-Allow-Origin", "*");
//        res.setHeader("Access-Control-Allow-Credentials", "true");
//        res.setContentType("application/json");
//        res.setCharacterEncoding("UTF-8");
//        res.getWriter().write("{\"code\":100009 ,\"message\" :\"解析token失败\"}");
//        res.flushBuffer();
//    }
//
//    private boolean isHaveAccess(Object handler) {
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//
//        Method method = handlerMethod.getMethod();
//
//        NoNeedAccessAuthentication responseBody = AnnotationUtils.findAnnotation(method, NoNeedAccessAuthentication.class);
//        return responseBody != null;
//    }
//}
