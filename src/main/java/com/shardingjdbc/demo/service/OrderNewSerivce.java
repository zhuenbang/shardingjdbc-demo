package com.shardingjdbc.demo.service;

import com.shardingjdbc.demo.entity.OrderNewInfoEntity;
import com.shardingjdbc.demo.mapper.OrderNewMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: OrderNewSerivce
 * @Description: OrderNewSerivce
 * @author: Ryan zhu
 * @date: 2022/12/9 14:12
 */
@Service
@Log4j2
public class OrderNewSerivce {
    @Autowired
    private OrderNewMapper orderNewMapper;

    public List<OrderNewInfoEntity> queryOrderInfoList(OrderNewInfoEntity orderInfo) {
        return orderNewMapper.queryOrderInfoList(orderInfo);
    }

    public OrderNewInfoEntity queryOrderInfoByOrderId(OrderNewInfoEntity orderInfo) {
        return orderNewMapper.queryOrderInfoByOrderId(orderInfo);
    }

    public int addOrder(OrderNewInfoEntity orderInfo) {
        log.info("订单入库开始，orderinfo={}", orderInfo.toString());
        return orderNewMapper.addOrder(orderInfo);
    }
}
