package com.shardingjdbc.demo.mapper;

import com.shardingjdbc.demo.entity.OrderNewInfoEntity;

import java.util.List;

/**
 * @ClassName: OrderNewMapper
 * @Description: 订单NewMapper
 * @author: Ryan zhu
 * @date: 2022/12/9 14:12
 */
public interface OrderNewMapper {
    List<OrderNewInfoEntity> queryOrderInfoList(OrderNewInfoEntity orderInfo);

    OrderNewInfoEntity queryOrderInfoByOrderId(OrderNewInfoEntity orderInfo);

    int addOrder(OrderNewInfoEntity orderInfo);
}
