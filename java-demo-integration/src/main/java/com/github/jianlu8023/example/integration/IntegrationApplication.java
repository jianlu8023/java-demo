package com.github.jianlu8023.example.integration;

import com.github.jianlu8023.utils.format.annotation.*;
import org.slf4j.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.transaction.annotation.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableScheduling
@EnableTransactionManagement
@EnableFormat
public class IntegrationApplication {
    private static final Logger L = LoggerFactory.getLogger(IntegrationApplication.class);

    static {
        // 设置property 关闭 pagehelper 的banner
        // L.debug("pagehelper banner is disabled");
        System.setProperty("pagehelper.banner", "false");
    }

    public static void main(String[] args) {
        SpringApplication.run(IntegrationApplication.class, args);
    }

}
