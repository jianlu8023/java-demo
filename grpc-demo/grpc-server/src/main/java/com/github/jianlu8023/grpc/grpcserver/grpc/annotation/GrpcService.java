package com.github.jianlu8023.grpc.grpcserver.grpc.annotation;

import org.springframework.stereotype.*;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface GrpcService {
}
