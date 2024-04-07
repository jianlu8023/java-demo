package com.github.jianlu8023.grpc.grpcclient.grpc.config;

import com.github.jianlu8023.grpc.proto.hello.*;
import com.github.jianlu8023.grpc.proto.ping.*;
import io.grpc.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

@Configuration
public class GrpcClientConfig {

    @Value("${grpc.port:9092}")
    private Integer port;

    @Bean
    public ManagedChannel getChannel() {
        return ManagedChannelBuilder.forAddress("192.168.58.131", port)
                .usePlaintext()
                .build();
    }

    @Bean
    public HelloServiceGrpc.HelloServiceBlockingStub getStub1(ManagedChannel channel) {
        return HelloServiceGrpc.newBlockingStub(channel);
    }

    @Bean
    public PingServiceGrpc.PingServiceBlockingStub pingServiceBlockingStub(ManagedChannel channel) {
        return PingServiceGrpc.newBlockingStub(channel);
    }

}
