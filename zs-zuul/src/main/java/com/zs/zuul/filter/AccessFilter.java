package com.zs.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import util.jwt.JwtHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author Xc
 * @version 创建时间：2019年5月31日 下午5:06:13
 * @ClassName 类名称
 * @Description 类描述
 */
@Slf4j
@Component
public class AccessFilter extends ZuulFilter {

    private static final String BEARER_TOKEN_TYPE = "token ";
    private static final String OPTIONS = "OPTIONS";
    private static final String LOGIN_URI = "/login";
    private static final String AUTH_PATH = "/auth";
    private static final String SWAGGER_URI = "swagger";
    private static final String API_URI = "api-docs";

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        response.setContentType("application/json; charset=utf-8");
        //允许跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        String requestUrl = request.getRequestURI();
        System.out.println("requestUri=" + requestUrl);
        if (requestUrl.contains("auth")) {
            String token = request.getHeader("token");
            if (StringUtils.isEmpty(token)) {
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(200);
                ctx.setResponseBody("{\"code\":\"219\",\"msg\":\"TOKEN为空\",\"data\":\"\"}");
            } else {
                try {
                    JwtHelper.verifyToken(token);
                    ctx.addZuulRequestHeader("token", token);
                } catch (Exception e) {
                    // TOKEN验证失败
                    ctx.setSendZuulResponse(false);
                    ctx.setResponseStatusCode(200);
                    ctx.setResponseBody("{\"code\":\"220\",\"msg\":\"TOKEN校验失败!!!\",\"data\":\"\"}");
                }
            }
        }

        //后台请求
        if (requestUrl.contains("backstage")) {
            String authHeader = request.getHeader("Authorization1");
            if (StringUtils.isEmpty(authHeader)) {
                return null;
            }
            if (authHeader.startsWith(BEARER_TOKEN_TYPE)) {
                ctx.addZuulRequestHeader("Authorization1", authHeader);
                log.info("authHeader={} ", authHeader);
            }
        }

        Enumeration<String> paraNames = request.getParameterNames();
        for (Enumeration<String> e = paraNames; e.hasMoreElements(); ) {
            String thisName = e.nextElement();
            String thisValue = request.getParameter(thisName);
            System.out.println("param的key:" + thisName + "---param的value:" + thisValue);
        }

        return null;
    }
}







