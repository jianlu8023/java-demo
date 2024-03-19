package com.github.jianlu8023.javastudy.web.handler;

import com.github.jianlu8023.javastudy.web.format.*;
import org.springframework.core.*;
import org.springframework.http.*;
import org.springframework.http.converter.*;
import org.springframework.http.server.*;
import org.springframework.web.servlet.mvc.method.annotation.*;

// @RestControllerAdvice(basePackages = "com.github.jianlu8023")
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        // return false;
        return returnType.getParameterType() != Result.class;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        // // 数据封装为Result：将接口方法返回的数据，封装到 Result.data 字段中。
        // Result result = ResultGenerator.getSuccessResult(body);
        //
        // // 返回类型不是 String：直接返回
        // if (returnType.getParameterType() != String.class) {
        //     return result;
        // }
        //
        // // 返回类型是 String：不能直接返回，需要进行额外处理
        // // 1. 将 Content-Type 设为 application/json ；返回类型是String时，默认 Content-Type = text/plain
        // HttpHeaders headers = response.getHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        // // 2. 将 Result 转为 Json字符串 再返回
        // // （否则会报错 java.lang.ClassCastException: com.example.core.model.Result cannot be cast to java.lang.String）
        // // return JsonUtil.toJson(result);
        // return JSONObject.toJSONString(result);
        // // return null;

        if (!(body instanceof Result)){
            return ResultGenerator.getSuccessResult(body);
        }
        return body;
    }
}
