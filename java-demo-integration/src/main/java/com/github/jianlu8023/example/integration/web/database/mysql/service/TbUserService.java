package com.github.jianlu8023.example.integration.web.database.mysql.service;

import com.baomidou.mybatisplus.extension.service.*;
import com.github.jianlu8023.example.integration.web.database.mysql.entity.*;


public interface TbUserService extends IService<TbUser> {

    TbUser create();
}
