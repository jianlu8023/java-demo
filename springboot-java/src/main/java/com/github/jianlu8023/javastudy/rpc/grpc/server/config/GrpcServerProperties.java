package com.github.jianlu8023.javastudy.rpc.grpc.server.config;


import com.github.jianlu8023.javastudy.utils.*;
import org.springframework.boot.context.properties.*;

import java.net.*;

@ConfigurationProperties(prefix = "grpc")
public class GrpcServerProperties {

    /**
     * grpc 端口
     * <p>
     * create time: 2024/3/19 下午3:45
     * <p>
     * create by: ght
     */
    private Integer port;

    /**
     * grpc 连接地址
     * <p>
     * create time: 2024/3/19 下午3:46
     * <p>
     * create by: ght
     */
    private String ip;

    public GrpcServerProperties() {
    }

    @ConstructorBinding
    public GrpcServerProperties(Integer port, String ip) {
        this.port = port;
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getIp() {
        if (ip == null || ip.isEmpty()) {
            try {
                ip = NetInter.getRealInter().getIp();
            } catch (UnknownHostException | SocketException e) {
                // Handle exception
                e.printStackTrace();
            }
        }
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
