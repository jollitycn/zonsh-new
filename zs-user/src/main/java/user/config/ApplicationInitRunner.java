package user.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author liqun
 * @version 1.0
 * @date 2019/7/4 18:13
 * @description 启动程序提示
 */
@Component
@Slf4j
@Order(value = 1)
public class ApplicationInitRunner implements CommandLineRunner {

    /**
     * Run
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        log.info(">>>>>>>>>>>>>>>服务启动执行,执行加载数据等操作<<<<<<<<<<<<<");
    }
}
