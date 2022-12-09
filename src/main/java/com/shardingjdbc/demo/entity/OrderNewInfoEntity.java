package com.shardingjdbc.demo.entity;

import lombok.Data;


/**
 * @ClassName: OrderNewInfoEntity
 * @Description: 复合分片订单实体
 * @author: Ryan zhu
 * @date: 2022/12/9 14:05
 */
@Data
public class OrderNewInfoEntity {
    private Integer id;
    private String userId;
    private String orderId;
    private String userName;
}
