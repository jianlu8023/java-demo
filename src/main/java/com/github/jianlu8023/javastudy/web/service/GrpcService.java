package com.github.jianlu8023.javastudy.web.service;

import java.net.*;
import java.util.*;

public interface GrpcService {

    /**
     * ping
     *
     * create time: 2024/3/19 下午1:46
     *
     * create by: ght
     *
     * @param ip :
     *
     * @return Map<String,String>
     */
    Map<String, String> ping(String ip) throws SocketException, UnknownHostException;
}
