package com.shardingjdbc.demo.calc.pay;



public enum PayGroup  {

  THIRD_PAY(1, "三方支付"),
  PLATFORM_PAY(2,"平台支付"),
  VIRTUAL_PROPERTY(3,"虚拟资产"),
  BANK(4,"银行卡支付"),
  COUPON(4,"优惠劵")
  ;

  PayGroup(Integer code, String name) {
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



}
