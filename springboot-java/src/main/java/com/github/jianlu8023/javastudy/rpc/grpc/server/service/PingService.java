package com.github.jianlu8023.javastudy.rpc.grpc.server.service;

import com.github.jianlu8023.javastudy.rpc.grpc.annotation.*;
import com.github.jianlu8023.javastudy.rpc.grpc.proto.ping.*;
import io.grpc.stub.*;
import io.netty.util.*;
import org.slf4j.*;

@GrpcService
public class PingService extends PingServiceGrpc.PingServiceImplBase {

    private static final Logger L = LoggerFactory.getLogger(PingService.class);


    /**
     * @param request
     * @param responseObserver
     */
    @Override
    public void ping(PingRequest request, StreamObserver<PongResponse> responseObserver) {
        // super.ping(request, responseObserver);
        L.info("ping grpc...");
        L.info("{}", request);
        PongResponse response = PongResponse.newBuilder()
                .setException("")
                .setFromUid(NetUtil.LOCALHOST4.getCanonicalHostName())
                .setToUid(request.getFromUid())
                .setMessage("pong")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
