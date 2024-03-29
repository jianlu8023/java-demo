package com.github.jianlu8023.javastudy.web.format;

import com.fasterxml.jackson.annotation.*;

import java.io.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result implements Serializable {

    private int code;

    private String message = "success";

    private Object data;

    public Result setCode(ResultCodeEnum resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }
}
