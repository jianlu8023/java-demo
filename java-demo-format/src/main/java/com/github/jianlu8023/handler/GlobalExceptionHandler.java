package com.github.jianlu8023.handler;

import com.github.jianlu8023.format.ResponseStatus;
import com.github.jianlu8023.format.*;
import org.slf4j.*;
import org.springframework.validation.*;
import org.springframework.web.*;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.*;
import org.springframework.web.servlet.*;

import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger L = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({Exception.class})
    public ApiResponse<?> exception(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            // 参数检验异常
            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) e;
            Map<String, String> map = new HashMap<>();
            BindingResult result = methodArgumentNotValidException.getBindingResult();
            result.getFieldErrors().forEach((item) -> {
                String message = item.getDefaultMessage();
                String field = item.getField();
                map.put(field, message);
            });
            L.error("参数检验异常 {} ", methodArgumentNotValidException.getMessage(), methodArgumentNotValidException);
            return ApiResponse.error(ResponseStatus.PARAM_ERROR, map);
        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            L.error("请求方法错误：", e);
            return ApiResponse.error(ResponseStatus.BAD_REQUEST.getCode(), "请求方法不正确");
        } else if (e instanceof MissingServletRequestParameterException) {
            L.error("请求参数缺失：", e);
            MissingServletRequestParameterException ex = (MissingServletRequestParameterException) e;
            return ApiResponse.error(ResponseStatus.BAD_REQUEST.getCode(), "请求参数缺少: " + ex.getParameterName());
        } else if (e instanceof MethodArgumentTypeMismatchException) {
            L.error("请求参数类型错误：", e);
            MethodArgumentTypeMismatchException ex = (MethodArgumentTypeMismatchException) e;
            return ApiResponse.error(ResponseStatus.BAD_REQUEST.getCode(), "请求参数类型不正确：" + ex.getName());
        } else if (e instanceof NoHandlerFoundException) {
            NoHandlerFoundException ex = (NoHandlerFoundException) e;
            L.error("请求地址不存在：", e);
            return ApiResponse.error(ResponseStatus.METHOD_IMPLEMENTED, ex.getRequestURL());
        } else {
            //如果是系统的异常，比如空指针这些异常
            L.error("【系统异常】", e);
            return ApiResponse.error(ResponseStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 参数缺失异常处理
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ApiResponse<String> badRequestException(Exception ex) {
        L.error("缺失參數異常 {}", ex.getMessage());
        return ApiResponse.error(ResponseStatus.BAD_REQUEST.getCode(), "缺少必填参数！");
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public ApiResponse<String> handleTypeMismatchException(NullPointerException ex) {
        L.error("空指针异常，{}", ex.getMessage());
        return ApiResponse.error("空指针异常");
    }

    /**
     * 系统异常处理
     */
    @ExceptionHandler(Throwable.class)
    public ApiResponse<String> exception(Throwable throwable) {
        L.error("系统异常", throwable);
        return ApiResponse.error(ResponseStatus.INTERNAL_SERVER_ERROR);
    }
}
