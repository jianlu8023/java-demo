package com.github.jianlu8023.javastudy;


import com.github.jianlu8023.javastudy.rpc.grpc.server.config.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.context.properties.*;
import org.springframework.cache.annotation.*;
import org.springframework.scheduling.annotation.*;

@EnableAsync
@EnableCaching
@EnableConfigurationProperties({GrpcServerProperties.class})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
