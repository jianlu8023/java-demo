package com.github.jianlu8023.example.integration.web.controller;

import com.github.jianlu8023.utils.format.response.ResponseStatus;
import com.github.jianlu8023.utils.format.response.*;
import com.github.jianlu8023.utils.generator.address.*;
import com.github.jianlu8023.utils.generator.mobile.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mock")
public class MockController {

    private ChineseMobileNumberGenerator mobileNumberGenerator;

    @Autowired
    public void setMobileNumberGenerator(ChineseMobileNumberGenerator mobileNumberGenerator) {
        this.mobileNumberGenerator = mobileNumberGenerator;
    }

    private ChineseAddressGenerator addressGenerator;

    @Autowired
    public void setAddressGenerator(ChineseAddressGenerator addressGenerator) {
        this.addressGenerator = addressGenerator;
    }

    @RequestMapping(value = "/tel", method = {
            RequestMethod.GET, RequestMethod.POST
    })
    public ApiResponse<Object> mockTel() {
        return ApiResponse.success(ResponseStatus.SUCCESS, mobileNumberGenerator.generate());
    }

    @RequestMapping(value = "/addr", method = {
            RequestMethod.GET, RequestMethod.POST
    })
    public ApiResponse<Object> mockAddr() {
        String generate = addressGenerator.generate();
        return ApiResponse.success(ResponseStatus.SUCCESS, generate);
    }
}
