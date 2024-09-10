package com.github.jianlu8023.example.integration.web.database.pgsql.mapper;

import com.github.jianlu8023.example.integration.web.database.pgsql.entity.FileUploadRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author root
* @description 针对表【file_upload_record】的数据库操作Mapper
* @createDate 2024-09-10 11:52:06
* @Entity com.github.jianlu8023.example.integration.web.database.pgsql.entity.FileUploadRecord
*/
@Mapper
public interface FileUploadRecordMapper extends BaseMapper<FileUploadRecord> {

}




