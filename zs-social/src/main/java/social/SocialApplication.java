package social;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
* @author Xc
* @version 创建时间：2019年5月27日 下午5:36:26
* @ClassName 评论服务启动类
* @Description 类描述
*/

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan("social.mapper")
@EnableScheduling
public class SocialApplication {

	public static void main(final String[] args) {
		SpringApplication.run(SocialApplication.class, args);
	}

	 @Bean
	  public PaginationInterceptor paginationInterceptor() {
	      PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
	      return paginationInterceptor;
	  }
	
}


