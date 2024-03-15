package com.github.jianlu8023.javastudy.web.service.impl;

import com.github.jianlu8023.javastudy.web.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class DaMengServiceImpl implements DaMengService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Map<String, Object>> queryDbVersion() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT banner as 版本信息 FROM v$version");
        return maps;
    }
}
