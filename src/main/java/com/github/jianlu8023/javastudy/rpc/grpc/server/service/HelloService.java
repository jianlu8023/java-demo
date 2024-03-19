package com.github.jianlu8023.javastudy.rpc.grpc.server.service;

import com.github.jianlu8023.javastudy.rpc.grpc.annotation.*;
import com.github.jianlu8023.javastudy.rpc.grpc.proto.hello.*;
import io.grpc.stub.*;
import io.netty.util.*;
import org.slf4j.*;

@GrpcService
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {

    private static final Logger L = LoggerFactory.getLogger(HelloService.class);


    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        // super.sayHello(request, responseObserver);

        L.info("sayHello grpc...");
        L.info("{}", request);
        HelloResponse response = HelloResponse.newBuilder()
                .setFromUid(NetUtil.toAddressString(NetUtil.LOCALHOST))
                .setMessage("hello " + request.getMessage())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
