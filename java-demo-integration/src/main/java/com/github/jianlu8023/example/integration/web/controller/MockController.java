package com.github.jianlu8023.example.integration.web.controller;

import com.github.jianlu8023.example.integration.web.service.*;
import com.github.jianlu8023.utils.format.annotation.*;
import com.github.jianlu8023.utils.format.response.ResponseStatus;
import com.github.jianlu8023.utils.format.response.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mock")
public class MockController {

    private MockService mockService;

    @Autowired
    public void setMockService(MockService mockService) {
        this.mockService = mockService;
    }

    @RequestMapping(value = "/tel", method = {
            RequestMethod.GET, RequestMethod.POST
    })

    @RequestLog
    public ApiResponse<Object> mockTel() {
        return ApiResponse.success(ResponseStatus.SUCCESS, mockService.mockTel());
    }

    @RequestMapping(value = "/addr", method = {
            RequestMethod.GET, RequestMethod.POST
    })
    public ApiResponse<Object> mockAddr() {
        return ApiResponse.success(ResponseStatus.SUCCESS, mockService.mockAddr());
    }
}
