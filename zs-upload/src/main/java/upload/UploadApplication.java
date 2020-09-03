package upload;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



/**
* @author Xc
* @version 创建时间：2019年5月27日 下午5:36:26
* @ClassName 上传服务启动类
* @Description 类描述
*/

@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) 
public class UploadApplication {

	public static void main(final String[] args) {
		SpringApplication.run(UploadApplication.class, args);
	}



}


