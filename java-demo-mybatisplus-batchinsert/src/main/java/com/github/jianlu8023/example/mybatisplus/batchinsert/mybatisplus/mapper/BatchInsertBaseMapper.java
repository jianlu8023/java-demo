package com.github.jianlu8023.example.mybatisplus.batchinsert.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.*;

import java.util.*;

public interface BatchInsertBaseMapper<T> extends BaseMapper<T> {


    Integer insertBatchSomeColumn(Collection<T> batchList);
}
