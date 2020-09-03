package com.zs.zuul.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* @author Xc
* @version 创建时间：2019年5月30日 上午10:59:28
* @ClassName 类名称
* @Description 类描述
*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	 @Bean
	    public Docket createRestApi() {
		 
		 
		 
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo());
	    }

	    private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("重拾接口文档")
	                .description("重拾系统接口文档说明")
	                .termsOfServiceUrl("http://localhost:8080")
	                .contact(new Contact("xc", "", "*****@****.com"))
	                .version("1.0")
	                .build();
	    }

	    @Bean
	    UiConfiguration uiConfig() {
	        return new UiConfiguration(null, "list", "alpha", "schema",
	                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
	    }
	
	
}


