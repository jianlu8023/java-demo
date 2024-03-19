package com.github.jianlu8023.javastudy.web.format;

public enum ResultCodeEnum {

    SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500);//服务器内部错误

    private Integer code;

    ResultCodeEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
