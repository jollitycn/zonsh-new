package com.zs.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
* @author Xc
* @version 创建时间：2019年5月31日 下午5:32:43
* @ClassName 类名称
* @Description 类描述
*/
@Component
@Configuration
public class GateWayCorsConfig {

	 @Bean
	    public CorsFilter corsFilter() {
	        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        final CorsConfiguration corsConfiguration = new CorsConfiguration();
	        corsConfiguration.addAllowedHeader("*");
	        corsConfiguration.addAllowedOrigin("*");
	        corsConfiguration.addAllowedMethod("*");
	        source.registerCorsConfiguration("/**", corsConfiguration);
	        return new CorsFilter(source);
	    }
	
}


