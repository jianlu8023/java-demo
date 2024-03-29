package com.github.jianlu8023.javastudy.rpc.grpc.client.config;

import com.github.jianlu8023.javastudy.rpc.grpc.proto.hello.*;
import com.github.jianlu8023.javastudy.rpc.grpc.proto.ping.*;
import com.github.jianlu8023.javastudy.rpc.grpc.server.config.*;
import io.grpc.*;
import org.springframework.context.annotation.*;

@Configuration
public class GrpcClientConfig {

    @Bean
    public ManagedChannel getChannel(GrpcServerProperties grpcServerProperties) {
        return ManagedChannelBuilder.forAddress(grpcServerProperties.getIp(), grpcServerProperties.getPort())
                .usePlaintext()
                .build();
    }

    @Bean
    public HelloServiceGrpc.HelloServiceBlockingStub getStub1(ManagedChannel channel) {
        return HelloServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    public PingServiceGrpc.PingServiceBlockingStub getStub2(ManagedChannel channel) {
        return PingServiceGrpc.newBlockingStub(channel);
    }

}
