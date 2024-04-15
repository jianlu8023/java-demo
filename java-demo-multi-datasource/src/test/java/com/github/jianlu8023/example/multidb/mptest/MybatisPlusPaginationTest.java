package com.github.jianlu8023.example.multidb.mptest;

import com.baomidou.mybatisplus.core.conditions.query.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.*;
import com.github.jianlu8023.example.multidb.web.db1.entity.*;
import com.github.jianlu8023.example.multidb.web.db1.service.*;
import com.github.jianlu8023.example.multidb.web.db2.service.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.util.*;

@SpringBootTest
public class MybatisPlusPaginationTest {

    @Autowired
    private BasicTestUserService basicTestUserService;

    @Autowired
    private CertInfoService certInfoService;

    @Test
    void paginationTest() {
        LambdaQueryWrapper<BasicTestUser> paginationWrapper = new LambdaQueryWrapper<>();
        long count = basicTestUserService.count(paginationWrapper);

        long pageCount = count % 2 == 0 ? count / 2 : count / 2 + 1;

        for (int i = 1; i <= pageCount; i++) {

            List<BasicTestUser> records = basicTestUserService.page(new Page<BasicTestUser>(i, 2, count), paginationWrapper).getRecords();
            records.parallelStream().forEach(System.out::println);
        }

    }

}
