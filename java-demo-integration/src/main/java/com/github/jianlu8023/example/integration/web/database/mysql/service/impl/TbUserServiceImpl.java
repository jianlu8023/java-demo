package com.github.jianlu8023.example.integration.web.database.mysql.service.impl;

import com.baomidou.dynamic.datasource.annotation.*;
import com.baomidou.mybatisplus.extension.service.impl.*;
import com.github.jianlu8023.example.integration.exceptions.*;
import com.github.jianlu8023.example.integration.web.database.mysql.entity.*;
import com.github.jianlu8023.example.integration.web.database.mysql.mapper.*;
import com.github.jianlu8023.example.integration.web.database.mysql.service.*;
import com.github.jianlu8023.utils.generator.pojo.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;


@Service
@DS("mysql")
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser>
        implements TbUserService {
    private static final Logger L = LoggerFactory.getLogger(TbUserServiceImpl.class);

    private PojoGenerator<TbUser> generator;

    @Autowired
    public void setGenerator(PojoGenerator<TbUser> generator) {
        this.generator = generator;
    }

    @Override
    @DS("mysql")
    public TbUser create() {
        final TbUser generate = generator.generate(TbUser.class);
        final boolean save = save(generate);
        if (save) {
            return generate;
        } else {
            throw new CreateFailException("create fail");
        }

    }
}




