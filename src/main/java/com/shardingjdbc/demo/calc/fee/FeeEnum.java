package com.shardingjdbc.demo.calc.fee;


/**
 * @author gim
 */
public enum FeeEnum {
  /**
   *
   */
  AMOUNT_GREATER_ERROR(2001, "抵扣金额过大,超过需要抵扣的金额"),
  FEE_ITEM_EMPTY(2002,"计费项为空")
  ;

  FeeEnum(Integer code, String name) {
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
