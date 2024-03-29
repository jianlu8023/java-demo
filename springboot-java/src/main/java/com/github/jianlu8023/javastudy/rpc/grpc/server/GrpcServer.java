package com.github.jianlu8023.javastudy.rpc.grpc.server;

import com.github.jianlu8023.javastudy.rpc.grpc.annotation.*;
import com.github.jianlu8023.javastudy.utils.*;
import io.grpc.*;
import org.slf4j.*;

import java.io.*;
import java.util.*;

public class GrpcServer implements Closeable {

    private static final Logger L = LoggerFactory.getLogger(GrpcServer.class);

    private Server server;

    private Integer port;
    private Boolean start;

    public GrpcServer() {
        this.start = false;
    }

    public GrpcServer(Integer port) {
        this.port = port;
        this.start = false;
    }

    public GrpcServer(Integer port, Boolean start) {
        this.port = port;
        this.start = start;
    }

    public Boolean getStart() {
        return start;
    }

    public void setStart(Boolean start) {
        this.start = start;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void init() throws IOException {
        if (!start) {
            ServerBuilder<?> serverBuilder = ServerBuilder.forPort(port);
            Map<String, Object> grpcServiceMap = SpringContextUtils.getBeansWithAnnotation(GrpcService.class);
            for (Object bean : grpcServiceMap.values()) {
                serverBuilder.addService((BindableService) bean);
                L.info("{} is registered in SpringBoot", bean.getClass().getSimpleName());
            }
            server = serverBuilder.build().start();
            L.info("gRPC server is started at {}", port);
            start = true;
        }
    }


    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     *
     * <p> As noted in {@link AutoCloseable#close()}, cases where the
     * close may fail require careful attention. It is strongly advised
     * to relinquish the underlying resources and to internally
     * <em>mark</em> the {@code Closeable} as closed, prior to throwing
     * the {@code IOException}.
     */
    @Override
    public void close() {
        L.info("*** shutting down gRPC server since JVM is shutting down");
        if (server != null) {
            server.shutdown();
            try {
                server.awaitTermination();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            start = false;
        }
        L.info("*** server shut down！！！！");
    }
}
