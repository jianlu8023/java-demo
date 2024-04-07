package com.github.jianlu8023.grpc.grpcclient.web.service.impl;

import com.github.jianlu8023.grpc.grpcclient.util.*;
import com.github.jianlu8023.grpc.grpcclient.web.service.*;
import com.github.jianlu8023.grpc.proto.ping.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class GrpcServiceImpl implements GrpcService {


    @Autowired
    private PingServiceGrpc.PingServiceBlockingStub pingServiceBlockingStub;

    @Override
    public void ping() throws Exception {

        Ping ping = Ping.newBuilder()
                .setId(1)
                .setIpaddr(InterUtils.getRealInter().getIp())
                .setMessage("ping")
                .build();

        Pong pong = pingServiceBlockingStub.ping(ping);
        System.out.println(pong);
    }
}
