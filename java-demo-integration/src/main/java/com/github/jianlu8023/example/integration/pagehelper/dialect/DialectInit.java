package com.github.jianlu8023.example.integration.pagehelper.dialect;

import com.github.pagehelper.page.*;
import org.slf4j.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;

@Component
public class DialectInit implements ApplicationRunner {
    private static final Logger L = LoggerFactory.getLogger(DialectInit.class);

    @Override
    public void run(ApplicationArguments args) {
        L.debug(">>> Registering custom dialects");
        PageAutoDialect.registerDialectAlias("mysql", LocalMysqlDialect.class);
    }
}
