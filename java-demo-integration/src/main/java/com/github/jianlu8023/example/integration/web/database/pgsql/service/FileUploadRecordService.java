package com.github.jianlu8023.example.integration.web.database.pgsql.service;

import com.github.jianlu8023.example.integration.web.database.pgsql.entity.FileUploadRecord;
import com.baomidou.mybatisplus.extension.service.IService;

public interface FileUploadRecordService extends IService<FileUploadRecord> {

    FileUploadRecord create();
}
