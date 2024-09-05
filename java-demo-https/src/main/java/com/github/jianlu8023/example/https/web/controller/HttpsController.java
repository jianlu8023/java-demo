package com.github.jianlu8023.example.https.web.controller;

import com.alibaba.fastjson.*;
import com.alibaba.fastjson.serializer.*;
import com.github.jianlu8023.utils.format.response.*;
import org.slf4j.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.util.*;

@RestController
@RequestMapping("/https")
public class HttpsController {
    private static final Logger L = LoggerFactory.getLogger(HttpsController.class);

    @PostMapping("/rec")
    public ApiResponse<String> rec(HttpServletRequest request) {
        L.debug("request info \n-----------------------\n{}\n-----------------------", JSONObject.toJSONString(new HashMap<String, Object>() {{
            put("User-Agent", request.getHeader("User-Agent"));
            put("Content-Type", request.getHeader("Content-Type"));
            put("Content-Length", request.getHeader("Content-Length"));
            put("Form", request.getRemoteAddr());
        }}, SerializerFeature.PrettyFormat));
        return ApiResponse.success("ok");
    }
}
