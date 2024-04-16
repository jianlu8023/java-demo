package com.github.jianlu8023.example.multidb.mptest;

import com.baomidou.mybatisplus.core.conditions.query.*;
import com.github.jianlu8023.example.multidb.web.db1.entity.*;
import com.github.jianlu8023.example.multidb.web.db1.service.*;
import com.github.jianlu8023.utils.generator.pojo.*;
import com.github.jianlu8023.utils.generator.utils.*;
import com.github.pagehelper.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.util.*;

@SpringBootTest
public class MybatisPlusPaginationTest {

    @Autowired
    private PojoGenerator<User> pojoGenerator;

    @Autowired
    private UserService userService;


    void init(Integer size) {
        long count = userService.count();
        if (0 == count) {
            insert(size);
        }
    }

    void insert(Integer size) {
        List<User> insert = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User mock = pojoGenerator.generate(User.class);
            insert.add(mock);
        }
        insert.forEach(entity -> System.out.println(JsonUtils.toJSONString(entity)));
        userService.saveBatch(insert);
    }

    @Test
    void paginationTest() {
        init(100);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(User::getUserId);
        long count = userService.count(wrapper);

        long pageSum = count / 5 == 0 ? (count / 5) : ((count / 5) + 1);


        for (int i = 0; i < pageSum; i++) {
            PageHelper.startPage(i, 5, true);

            List<User> list = new PageInfo<>(userService.list(wrapper)).getList();
            list.forEach(entity -> System.out.println(JsonUtils.toJSONString(entity)));
        }
    }

}
