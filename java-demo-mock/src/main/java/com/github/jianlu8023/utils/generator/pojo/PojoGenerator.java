package com.github.jianlu8023.utils.generator.pojo;

import com.github.jianlu8023.utils.generator.*;
import com.github.jianlu8023.utils.generator.address.*;
import com.github.jianlu8023.utils.generator.email.*;
import com.github.jianlu8023.utils.generator.identity.*;
import com.github.jianlu8023.utils.generator.utils.*;
import com.github.jianlu8023.utils.testdata.entity.*;
import com.github.jsonzou.jmockdata.*;

import java.lang.reflect.*;

public class PojoGenerator<T> extends AbstractGenerator<T> {
    private static class PojoGeneratorHolder {
        private static final PojoGenerator<?> INSTANCE = new PojoGenerator<>();
    }

    private static MockConfig mockConfig = new MockConfig();
    private static volatile PojoGenerator<?> instance;
    private static final Object lock = new Object();


    private PojoGenerator() {
        mockConfig.globalConfig().excludes("Uid", "uid", "UID", "createTime", "updateTime");
        mockConfig.globalConfig().registerBeanMockerInterceptor((clazz, filed, obj, dc) -> {
            if (filed.getName().toLowerCase().contains("id")) {
                return IdentityIDGenerator.newInstance().generate();
            } else if (filed.getName().toLowerCase().contains("address")) {
                return ChineseAddressGenerator.newInstance().generate();
            } else if (filed.getName().toLowerCase().contains("email")) {
                return EmailGenerator.newInstance().generate();
            } else {
                return InterceptType.MOCK;
            }
        });
        mockConfig.subConfig("*age").intRange(10, 80);
        mockConfig.subConfig("*sex", "*gender").intRange(0, 1);
        mockConfig.subConfig("*birth*", "birth*", "*birth").dateRange("1970-01-01", "2025-01-01");

    }


    public static void setMockConfig(MockConfig mockConfig) {
        PojoGenerator.mockConfig = mockConfig;
    }

    public static <T> PojoGenerator<T> newInstance() {
        // Double-checked locking pattern
        // if (instance == null) {
        //     synchronized (lock) {
        //         if (instance == null) {
        //             instance = new PojoGenerator<>();
        //         }
        //     }
        // }
        // return (PojoGenerator<T>) instance;
        return (PojoGenerator<T>) PojoGeneratorHolder.INSTANCE;
    }

    @Override
    public T generate(Class<T> clazz) {
        return JMockData.mock(clazz, mockConfig);
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Generator<User> objectPojoGenerator = PojoGenerator.newInstance();
        User generate;
        for (int i = 0; i < 100; i++) {
            generate = objectPojoGenerator.generate(User.class);
            System.out.println(JsonUtils.toJSONString(generate));
        }

    }
}
