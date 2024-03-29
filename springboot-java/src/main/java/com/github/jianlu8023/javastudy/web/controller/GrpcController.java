package com.github.jianlu8023.javastudy.web.controller;


import com.github.jianlu8023.javastudy.web.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.net.*;
import java.util.*;

@RestController
@RequestMapping("/grpc")
public class GrpcController {


    private GrpcService grpcService;

    @Autowired
    public void setGrpcService(GrpcService grpcService) {
        this.grpcService = grpcService;
    }


    @RequestMapping("/ping")
    public Map<String, String> ping(@RequestParam("msg") String msg) throws SocketException, UnknownHostException {
        return grpcService.ping(msg);
    }

}
