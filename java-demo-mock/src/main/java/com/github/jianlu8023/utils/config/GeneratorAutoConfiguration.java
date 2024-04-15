package com.github.jianlu8023.utils.config;

import com.github.jianlu8023.utils.generator.address.*;
import com.github.jianlu8023.utils.generator.identity.*;
import com.github.jianlu8023.utils.generator.mobile.*;
import org.springframework.context.annotation.*;

@Configuration
public class GeneratorAutoConfiguration {

    @Bean
    IdentityIDGenerator identityIDGenerator() {
        return IdentityIDGenerator.newInstance();
    }

    @Bean
    ChineseMobileNumberGenerator chineseMobileNumberGenerator() {
        return ChineseMobileNumberGenerator.newInstance();
    }

    @Bean
    ChineseAddressGenerator chineseAddressGenerator() {
        return ChineseAddressGenerator.newInstance();
    }

}
