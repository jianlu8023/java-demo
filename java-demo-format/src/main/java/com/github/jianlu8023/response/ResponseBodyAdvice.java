package com.github.jianlu8023.response;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.github.jianlu8023.annotation.*;
import com.github.jianlu8023.format.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.*;
import org.springframework.core.annotation.*;
import org.springframework.http.*;
import org.springframework.http.converter.*;
import org.springframework.http.server.*;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.*;
import java.util.*;

@RestControllerAdvice
public class ResponseBodyAdvice implements org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice<Object> {

    private ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    private static final Class<? extends Annotation> ANNOTATION_TYPE = ResponseBodyCheck.class;

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ANNOTATION_TYPE)
                || returnType.hasMethodAnnotation(ANNOTATION_TYPE);
    }


    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        //如果返回类型是string，那么springmvc是直接返回的，此时需要手动转化为json
        // 当body都为null时，下面的if判断条件都不满足，如果接口返回类似为String，
        // 会报错cannot be cast to java.lang.String
        Class<?> returnClass = Objects.requireNonNull(returnType.getMethod()).getReturnType();
        if (body instanceof String || Objects.equals(returnClass, String.class)) {
            String value = null;
            try {
                value = objectMapper.writeValueAsString(ApiResponse.success(body));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return value;
        }
        // 防止重复包裹的问题出现
        if (body instanceof ApiResponse) {
            return body;
        }
        return ApiResponse.success(body);
    }
}
