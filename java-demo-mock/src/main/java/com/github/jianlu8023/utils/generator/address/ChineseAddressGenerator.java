package com.github.jianlu8023.utils.generator.address;

import com.github.jianlu8023.utils.generator.*;
import com.github.jianlu8023.utils.generator.utils.*;
import org.apache.commons.lang3.*;

public class ChineseAddressGenerator extends Generator {


    private static final ChineseAddressGenerator instance = new ChineseAddressGenerator();

    private ChineseAddressGenerator() {

    }

    public static ChineseAddressGenerator newInstance() {
        return instance;
    }

    @Override
    public String generator() {
        return genProvinceAndCity() + ChineseCharUtils.genRandomLengthChineseChars(2, 3) + "路" +
                RandomUtils.nextInt(1, 8000) + "号" +
                ChineseCharUtils.genRandomLengthChineseChars(2, 3) + "小区" +
                RandomUtils.nextInt(1, 20) + "单元" +
                RandomUtils.nextInt(101, 2500) + "室";
    }

    private static String genProvinceAndCity() {
        return ChineseAreaList.provinceCityList.get(
                RandomUtils.nextInt(0, ChineseAreaList.provinceCityList.size()));
    }
}
