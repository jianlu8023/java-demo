package com.github.jianlu8023.javastudy.rpc.grpc.server.config;

import com.github.jianlu8023.javastudy.rpc.grpc.server.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.*;

@Configuration
@ConditionalOnClass({GrpcServerProperties.class})
public class GrpcServerConfig {

    private GrpcServerProperties grpcServerProperties;

    @Autowired
    public void setGrpcServerProperties(GrpcServerProperties grpcServerProperties) {
        this.grpcServerProperties = grpcServerProperties;
    }

    @Bean(
            initMethod = "init"
    )
    public GrpcServer grpcServer() {
        return new GrpcServer(grpcServerProperties.getPort());
    }
}
