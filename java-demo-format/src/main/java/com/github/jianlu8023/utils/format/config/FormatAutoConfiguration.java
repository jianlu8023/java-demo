package com.github.jianlu8023.utils.format.config;

import com.github.jianlu8023.utils.format.advice.exception.*;
import com.github.jianlu8023.utils.format.advice.response.*;
import lombok.extern.slf4j.*;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.*;

@Configuration
@Slf4j
public class FormatAutoConfiguration {

    @Bean
    @ConditionalOnClass(GlobalExceptionHandler.class)
    GlobalExceptionHandler globalExceptionHandler() {
        log.info("inject globalExceptionHandler...");
        return new GlobalExceptionHandler();
    }

    @Bean
    @ConditionalOnClass(ResponseBodyResultAdvice.class)
    ResponseBodyResultAdvice responseBodyResultAdvice() {
        log.info("inject responseBodyResultAdvice");
        return new ResponseBodyResultAdvice();
    }
}
