package com.github.jianlu8023.example.multidb.mptest;

import com.github.jianlu8023.example.multidb.web.db1.entity.*;
import com.github.jianlu8023.example.multidb.web.db1.service.*;
import com.github.jianlu8023.utils.generator.identity.*;
import com.github.jsonzou.jmockdata.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;

import java.util.*;

@SpringBootTest
public class MybatisPlusPaginationTest {

    @Autowired
    private IdentityIDGenerator idGenerator;

    @Autowired
    private UserService userService;


    void init(Integer size) {
        long count = userService.count();
        if (0 == count) {
            insert(size);
        }
    }

    void insert(Integer size) {

        MockConfig mockConfig = new MockConfig();
        mockConfig.excludes(User.class, "uid", "createTime", "updateTime");
        mockConfig.subConfig(User.class, "userAge").intRange(10, 80);
        mockConfig.subConfig(User.class, "userGender").intRange(0, 1);
        mockConfig.subConfig(User.class, "userEmail").stringRegex("[a-z0-9]{5,15}\\@\\w{3,5}\\.[a-z]{2,3}");

        List<User> insert = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User mock = JMockData.mock(User.class, mockConfig);
            mock.setUserId(idGenerator.generator());
            insert.add(mock);
        }
        userService.saveBatch(insert);
    }

    @Test
    void paginationTest() {
        init(100);
    }

}
