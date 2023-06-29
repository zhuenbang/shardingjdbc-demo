package com.shardingjdbc.demo.calc.pay;

import java.math.BigDecimal;

/**
 * @author gim 2021/12/2 8:31 下午
 */
public abstract class AbstractPayItem implements PayItem{

  private BigDecimal money;

  private PayType payType;

  private PayGroup payGroup;

  public AbstractPayItem(BigDecimal money,PayType payType,PayGroup payGroup){
    this.money = money;
    this.payType = payType;
    this.payGroup = payGroup;
  }

  @Override
  public BigDecimal getMoney() {
    return this.money;
  }

  @Override
  public PayGroup getPayGroup() {
    return this.payGroup;
  }

  @Override
  public PayType getPayType() {
    return this.payType;
  }
}
