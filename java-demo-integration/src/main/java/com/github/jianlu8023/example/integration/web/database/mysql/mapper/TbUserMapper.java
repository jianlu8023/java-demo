package com.github.jianlu8023.example.integration.web.database.mysql.mapper;

import com.github.jianlu8023.example.integration.web.database.mysql.entity.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author root
* @description 针对表【tb_user】的数据库操作Mapper
* @createDate 2024-09-10 11:29:54
* @Entity com.github.jianlu8023.example.integration.web.database.mysql.entity.TbUser
*/
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {

}




