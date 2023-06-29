package com.shardingjdbc.demo;

import com.shardingjdbc.demo.constant.DbAndTableEnum;
import com.shardingjdbc.demo.entity.OrderNewInfoEntity;
import com.shardingjdbc.demo.entity.PictureEntity;
import com.shardingjdbc.demo.mapper.OrderNewMapper;
import com.shardingjdbc.demo.mapper.PictureMapper;
import com.shardingjdbc.demo.sequence.KeyGenerator;
import com.shardingjdbc.demo.service.OrderNewSerivce;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
class ShardingjdbcDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    OrderNewSerivce orderNewSerivce;
    @Autowired
    private KeyGenerator keyGenerator;
    @Autowired
    private OrderNewMapper orderNewMapper;
    @Autowired
    private PictureMapper pictureMapper;

    /**
     * 测试分布式主键生成
     */
    @Test
    public void testGenerateId() {
        // 支付宝或者微信uid
        String outId = "20881007434917916336963360919773";
        log.info("获取id开始");
        String innerUserId = keyGenerator.generateKey(DbAndTableEnum.T_USER, outId);
        log.info("外部id={},innerUserId={}", outId, innerUserId);
        String orderId = keyGenerator.generateKey(DbAndTableEnum.T_NEW_ORDER, innerUserId);
        log.info("外部id={},innerUserId={},orderId={}", outId, innerUserId, orderId);
    }


    /**
     * 测试新的订单入库
     */
    @Test
    public void testNewOrderInsert() {
        // 支付宝或者微信uid
        for (int i = 0; i < 1; i++) {
            String outId = "1232132131241241243126" + i;
            log.info("获取id开始");
            String innerUserId = keyGenerator.generateKey(DbAndTableEnum.T_USER, outId);
            log.info("外部id={},内部用户={}", outId, innerUserId);
            String orderId = keyGenerator.generateKey(DbAndTableEnum.T_NEW_ORDER, innerUserId);
            log.info("外部id={},内部用户={},订单={}", outId, innerUserId, orderId);
            OrderNewInfoEntity orderInfo = new OrderNewInfoEntity();
            orderInfo.setUserName("snowalker");
            orderInfo.setUserId(innerUserId);
            orderInfo.setOrderId(orderId);
            orderNewMapper.addOrder(orderInfo);
        }

    }


    /**
     * 测试订单明细查询
     */
    @Test
    public void testQueryNewOrderById() {
        String orderId = "OD030001012212091737310393700002";
        String userId = "UD020000012212091737129623700013";
        OrderNewInfoEntity orderInfo = new OrderNewInfoEntity();
        orderInfo.setOrderId(orderId);
        orderInfo.setUserId(userId);
        System.out.println(orderNewSerivce.queryOrderInfoByOrderId(orderInfo));
    }

    /**
     * 测试订单列表查询
     */
    @Test
    public void testQueryNewOrderList() {
        String userId = "UD020000012304041725238113700100";
        OrderNewInfoEntity orderInfo = new OrderNewInfoEntity();
        orderInfo.setUserId(userId);
        List<OrderNewInfoEntity> list = new ArrayList<>();
        list = orderNewSerivce.queryOrderInfoList(orderInfo);
        System.out.println(list);
    }



    /**
     * 插入图片测试不分库分表
     */
    @Test
    public void testSavePicture() {
        PictureEntity pictureEntity = new PictureEntity();
        pictureEntity.setTitle("title");
        pictureEntity.setUrl("https://qa-secure.walmartmobile.cn/image/finda/T3-8F.jpg");
        pictureMapper.save(pictureEntity);
    }


}
