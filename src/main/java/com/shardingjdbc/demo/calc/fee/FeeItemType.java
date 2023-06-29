package com.shardingjdbc.demo.calc.fee;


/**
 * @author gim
 */
public enum FeeItemType{

  SERVICE_FEE(1, "服务费"),
  ELECTRIC_FEE(2,"电费"),
  OVER_WEIGHT_FEE(3,"超重费"),
  OVER_TIME_FEE(4,"超时费")
  ;

  FeeItemType(Integer code, String name) {
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
