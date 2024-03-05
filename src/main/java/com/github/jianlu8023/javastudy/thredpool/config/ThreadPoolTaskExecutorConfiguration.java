package com.github.jianlu8023.javastudy.thredpool.config;

import com.github.jianlu8023.javastudy.constant.*;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.concurrent.*;

@Configuration
public class ThreadPoolTaskExecutorConfiguration {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(Constants.CorePoolSize);

        executor.initialize();
        return executor;
    }
}
