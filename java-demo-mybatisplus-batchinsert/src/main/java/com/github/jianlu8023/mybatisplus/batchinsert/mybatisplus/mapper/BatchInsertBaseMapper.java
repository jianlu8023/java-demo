package com.github.jianlu8023.mybatisplus.batchinsert.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.*;

import java.util.*;

public interface BatchInsertBaseMapper<T> extends BaseMapper<T> {

    /**
     * insertBatchSomeColumn
     * <p>
     * create time: 2023/12/5 下午5:48
     * create by: jianlu8023
     *
     * @param batchList :
     * @return java.lang.Integer
     */
    Integer insertBatchSomeColumn(Collection<T> batchList);
}
