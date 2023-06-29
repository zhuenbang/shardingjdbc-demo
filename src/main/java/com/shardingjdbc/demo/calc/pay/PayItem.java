package com.shardingjdbc.demo.calc.pay;

import java.math.BigDecimal;

/**
 * @author gim 2021/12/2 8:25 下午
 */
public interface PayItem {

  BigDecimal getMoney();

  PayGroup getPayGroup();

  PayType getPayType();

}
