package backstage;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;

import backstage.interceptor.TokenInterceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.archaius.ArchaiusAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.HandlerInterceptor;


/**
* @author Xc
* @version 创建时间：2019年5月27日 下午5:36:26
* @ClassName 后台服务启动类
* @Description 
*/

@EnableDiscoveryClient
@SpringBootApplication(exclude = {ArchaiusAutoConfiguration.class})
@EnableFeignClients
@MapperScan("backstage.mapper")
@ComponentScan(basePackages = {"backstage","config"})
public class BackstageApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BackstageApplication.class, args);
	}

	/**
	 * ` 配置mybatis-plus分页插件的拦截器
	 * @return com.baomidou.mybatisplus.plugins.PaginationInterceptor
	 * @author  Pan Juncai
	 * @date 2019/7/1 14:33
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
		return paginationInterceptor;
	}
	
	 @Bean
	  @ConditionalOnMissingBean(HandlerInterceptor.class)
	  public TokenInterceptor tokenInterceptor() {
	       return new TokenInterceptor();
	   }
}


