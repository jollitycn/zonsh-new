package com.zs.zuul;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * @author Xc
 * @version 创建时间：2019年5月27日 下午4:13:49
 * @ClassName zuul网关
 * @Description 类描述
 */
@EnableZuulProxy
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ZuulApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	@Component
	@Primary
	class DocumentationConfig implements SwaggerResourcesProvider {

		@Override
		public List<SwaggerResource> get() {
			final List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
			resources.add(swaggerResource("用户服务","/user/v2/api-docs","2.0"));
			resources.add(swaggerResource("话题服务","/question/v2/api-docs","2.0"));
			resources.add(swaggerResource("后台管理服务","/backstage/v2/api-docs","2.0"));
			resources.add(swaggerResource("评论服务","/comment/v2/api-docs","2.0"));
			resources.add(swaggerResource("上传服务","/upload/v2/api-docs","2.0"));
			return resources;
		}

		private SwaggerResource swaggerResource(final String name, final String location, final String version) {
			final SwaggerResource swaggerResource = new SwaggerResource();
			swaggerResource.setName(name);
			swaggerResource.setLocation(location);
			swaggerResource.setSwaggerVersion(version);
			return swaggerResource;
		}
	}
}
