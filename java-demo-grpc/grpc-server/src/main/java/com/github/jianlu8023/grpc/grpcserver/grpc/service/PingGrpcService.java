package com.github.jianlu8023.grpc.grpcserver.grpc.service;


import com.github.jianlu8023.grpc.grpcserver.grpc.annotation.*;
import com.github.jianlu8023.grpc.proto.ping.*;
import io.grpc.stub.*;

import java.util.*;

@GrpcService
public class PingGrpcService extends PingServiceGrpc.PingServiceImplBase {

    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void ping(Ping request, StreamObserver<Pong> responseObserver) {
        // super.ping(request, responseObserver);
        System.out.println(request);
        Pong pong = Pong.newBuilder()
                .setId(new Random().nextInt(10000000))
                .setMessage("pong")
                .setIpaddr("demo").build();
        responseObserver.onNext(pong);
        responseObserver.onCompleted();
    }
}
