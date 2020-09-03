//package config;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import interceptor.TokenInterceptor;
//
///**
// * @author liqun
// * @version 1.0
// * @date 2019/7/13 0013 20:30
// * @description 系统核心配置
// */
//@Configuration
//public class CoreConfiguration {
//
////    @Bean
////    public RestTemplate restTemplate() {
////        return new RestTemplate();
////    }
//
////    @Bean
////    public SqlLogInterceptor sqlLogInterceptor() {
////        return new SqlLogInterceptor();
////    }
//
//    @Bean
//    @ConditionalOnMissingBean(HandlerInterceptor.class)
//    public TokenInterceptor tokenInterceptor() {
//        return new TokenInterceptor();
//    }
//}
