package com.github.jianlu8023.javastudy.web.controller;

import com.github.jianlu8023.javastudy.web.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/dm")
public class DaMengController {

    private DaMengService daMengService;

    @Autowired
    public DaMengController(DaMengService daMengService) {
        this.daMengService = daMengService;
    }

    @PostMapping("/dbVersion")
    public Object daMengVersion() {
        List<Map<String, Object>> maps = daMengService.queryDbVersion();
        return maps;
    }
}
