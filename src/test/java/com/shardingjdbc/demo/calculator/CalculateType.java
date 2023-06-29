package com.shardingjdbc.demo.calculator;


import com.shardingjdbc.demo.calc.fee.Unique;

import java.util.Optional;


public enum CalculateType implements Unique {

    COUPON(1, "优惠劵计算器"),
    ACTIVITY(2, "活动计算器");

    CalculateType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    private Integer code;
    private String name;


    public Integer getCode() {
        return this.code;
    }


    public String getName() {
        return this.name;
    }


    @Override
    public Integer getUniqueCode() {
        return this.code;
    }
}
