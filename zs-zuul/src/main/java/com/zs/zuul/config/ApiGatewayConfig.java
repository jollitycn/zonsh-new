package com.zs.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zs.zuul.filter.AccessFilter;

/**
* @author Xc
* @version 创建时间：2019年5月31日 下午5:10:38
* @ClassName 类名称
* @Description 类描述
*/
@Configuration
public class ApiGatewayConfig {

	@Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
	
}


