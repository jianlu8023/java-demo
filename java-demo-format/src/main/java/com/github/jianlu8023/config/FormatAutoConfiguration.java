package com.github.jianlu8023.config;

import com.github.jianlu8023.handler.*;
import com.github.jianlu8023.response.*;
import org.springframework.context.annotation.*;

@Configuration
// @EnableAutoConfiguration
public class FormatAutoConfiguration {
    @Bean
    GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    ResponseBodyAdvice responseBodyAdvice() {
        return new ResponseBodyAdvice();
    }
}
