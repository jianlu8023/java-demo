package com.github.jianlu8023.example.multidb;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class MultiDataSourceApplication {

    static {
        // 设置property 关闭 pagehelper 的banner
        System.setProperty("pagehelper.banner","false");
    }

    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceApplication.class, args);
    }
}
