package com.github.jianlu8023.mock.config;

import com.github.jianlu8023.mock.generator.address.*;
import com.github.jianlu8023.mock.generator.email.*;
import com.github.jianlu8023.mock.generator.identity.*;
import com.github.jianlu8023.mock.generator.mobile.*;
import com.github.jianlu8023.mock.generator.pojo.*;
import com.github.jianlu8023.utils.generator.address.*;
import com.github.jianlu8023.utils.generator.email.*;
import com.github.jianlu8023.utils.generator.identity.*;
import com.github.jianlu8023.utils.generator.mobile.*;
import com.github.jianlu8023.utils.generator.pojo.*;
import lombok.extern.slf4j.*;
import org.springframework.context.annotation.*;

@Configuration
@Slf4j
public class GeneratorAutoConfiguration {

    @Bean
    IdentityIDGenerator identityIDGenerator() {
        log.debug("inject identityIDGenerator...");
        return IdentityIDGenerator.newInstance();
    }

    @Bean
    ChineseMobileNumberGenerator chineseMobileNumberGenerator() {
        log.debug("inject chineseMobileNumberGenerator...");
        return ChineseMobileNumberGenerator.newInstance();
    }

    @Bean
    ChineseAddressGenerator chineseAddressGenerator() {
        log.debug("inject chineseAddressGenerator...");
        return ChineseAddressGenerator.newInstance();
    }

    @Bean
    PojoGenerator<?> pojoGenerator() {
        log.debug("inject pojoGenerator...");
        return PojoGenerator.newInstance();
    }

    @Bean
    EmailGenerator emailGenerator() {
        log.debug("inject emailGenerator...");
        return EmailGenerator.newInstance();
    }

}
