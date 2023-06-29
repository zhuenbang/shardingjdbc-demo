package com.shardingjdbc.demo;

import com.shardingjdbc.demo.calc.fee.AbstractFeeItem;
import com.shardingjdbc.demo.calc.fee.FeeItemType;

import java.math.BigDecimal;

/**
 * @author gim 2021/12/6 8:28 下午
 */
public class ServiceFeeItem extends AbstractFeeItem<OrderInfo> {

  public ServiceFeeItem(OrderInfo orderInfo, FeeItemType itemType,
      BigDecimal itemMoney) {
    super(orderInfo, itemType, itemMoney);
  }
}
