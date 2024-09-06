package com.github.jianlu8023.example.multidb.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.*;

import java.util.*;

public interface BatchInsertBaseMapper<T> extends BaseMapper<T> {


    Integer insertBatchSomeColumn(Collection<T> batchList);
}
