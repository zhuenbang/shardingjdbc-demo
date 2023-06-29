package com.shardingjdbc.demo.calculator;


import com.shardingjdbc.demo.calc.pay.AbstractPayItem;
import com.shardingjdbc.demo.calc.pay.PayGroup;
import com.shardingjdbc.demo.calc.pay.PayType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author gim 2021/12/6 8:47 下午
 */
@Setter
@Getter
public class ActivityPayItem extends AbstractPayItem {

  public ActivityPayItem(BigDecimal money) {
    super(money, PayType.ACTIVITY, PayGroup.COUPON);
  }

  private String activityName;
}
