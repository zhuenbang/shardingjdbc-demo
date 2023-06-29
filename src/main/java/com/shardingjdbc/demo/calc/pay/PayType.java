package com.shardingjdbc.demo.calc.pay;



/**
 * @author gim 2021/12/2 8:28 下午
 */
public enum PayType  {

  WECHAT(1, "微信支付"),
  ALIPAY(2,"支付宝"),
  COIN(3,"虚拟币"),
  ACTIVITY(4,"活动")
  ;

  PayType(Integer code, String name) {
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