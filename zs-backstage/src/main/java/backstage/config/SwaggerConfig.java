package backstage.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The class Swagger configuration.
 *
 * @author liqun
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	/**
	 * Reservation api docket.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket createRestApi() {
		//每次都需手动输入header信息
	/*	ParameterBuilder tokenPar  = new ParameterBuilder();
		List<Parameter> pars = new ArrayList();
		tokenPar.name("token").description("access_token")
				.modelRef(new ModelRef("string")).parameterType("header")
				.required(true).build(); //header中的token参数非必填，传空也可以
		pars.add(tokenPar.build());    //根据每个方法名也知道当前方法在设置什么参数 */
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("backstage"))
				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any())
				.build()
				//配置鉴权信息
				.securitySchemes(securitySchemes())
				.securityContexts(securityContexts())
//				.globalOperationParameters(pars);
				.enable(true);
}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("后台管理服务")
				.description("接口文档说明")
				.contact(new Contact("liqun", "", "1171335670@qq.com"))
				.version("2.2")
				.build();
	}

	private List<ApiKey> securitySchemes() {
		return new ArrayList(Collections.singleton(new ApiKey("Authorization", "Authorization1", "header")));
	}

	private List<SecurityContext> securityContexts() {
		return new ArrayList(
				Collections.singleton(SecurityContext.builder()
						.securityReferences(defaultAuth())
						.forPaths(PathSelectors.regex("^(?!login).*$"))
						.build())
		);
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return new ArrayList(Collections.singleton(new SecurityReference("Authorization", authorizationScopes)));
	}

}