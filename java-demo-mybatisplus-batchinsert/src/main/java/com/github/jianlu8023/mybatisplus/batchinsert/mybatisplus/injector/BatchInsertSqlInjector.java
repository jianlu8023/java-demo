package com.github.jianlu8023.mybatisplus.batchinsert.mybatisplus.injector;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.injector.*;
import com.baomidou.mybatisplus.core.metadata.*;
import com.baomidou.mybatisplus.extension.injector.methods.*;

import java.util.*;


public class BatchInsertSqlInjector extends DefaultSqlInjector {
    /**
     * getMethodList
     * <p>
     * create time: 2023/12/5 下午5:50
     * create by: jianlu8023
     *
     * @param mapperClass :
     * @param tableInfo   :
     * @return java.util.List<com.baomidou.mybatisplus.core.injector.AbstractMethod>
     */
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        methodList.add(new InsertBatchSomeColumn(t -> t.getFieldFill() != FieldFill.UPDATE));
        return methodList;
    }
}
