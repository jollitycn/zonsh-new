package user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;


/**
* @author Xc
* @version 创建时间：2019年5月27日 下午5:36:26
* @ClassName 用户服务启动类
* @Description 类描述
*/

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@MapperScan("user.mapper")
public class UserApplication {

	public static void main(final String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	 @Bean
	  public PaginationInterceptor paginationInterceptor() {
	      PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
	      return paginationInterceptor;
	  }
	
}


