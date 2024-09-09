package com.github.jianlu8023.example.integration.web.controller;

import com.github.jianlu8023.utils.format.response.ResponseStatus;
import com.github.jianlu8023.utils.format.response.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/status")
@RestController
public class StatusExampleController {
    @RequestMapping(
            value = "ping",
            method = {RequestMethod.DELETE, RequestMethod.GET,
                    RequestMethod.POST, RequestMethod.PUT}
    )
    public ApiResponse<Object> rec() {
        return ApiResponse.success(ResponseStatus.SUCCESS, "pong");
    }
}
