package com.shardingjdbc.demo.calculator;


import com.shardingjdbc.demo.calc.pay.AbstractPayItem;
import com.shardingjdbc.demo.calc.pay.PayGroup;
import com.shardingjdbc.demo.calc.pay.PayType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Setter
@Getter
public class CouponPayItem extends AbstractPayItem {

  public CouponPayItem(BigDecimal money) {
    super(money, PayType.COIN, PayGroup.COUPON);
  }

  private String couponCode;

  private String source;
}
