package com.github.jianlu8023.javastudy.web.service.impl;

import com.github.jianlu8023.javastudy.rpc.grpc.proto.ping.*;
import com.github.jianlu8023.javastudy.utils.*;
import com.github.jianlu8023.javastudy.web.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.net.*;
import java.util.*;

@Service
public class GrpcServiceImpl implements GrpcService {


    private PingServiceGrpc.PingServiceBlockingStub pingService;

    @Autowired
    public void setPingService(PingServiceGrpc.PingServiceBlockingStub pingService) {
        this.pingService = pingService;
    }

    /**
     * ping
     * <p>
     * create time: 2024/3/19 下午1:46
     * <p>
     * create by: ght
     *
     * @param message :
     *
     * @return Map<String, String>
     */
    @Override
    public Map<String, String> ping(String message) throws SocketException, UnknownHostException {
        PingRequest request = PingRequest.newBuilder()
                .setFromUid(message)
                .setFromUid(NetInter.getRealInter().getIp())
                .build();
        PongResponse pong = pingService.ping(request);
        pong.getMessage();

        return new HashMap<String, String>() {{
            put("msg", pong.getMessage());
            put("from", pong.getFromUid());
        }};
    }
}
