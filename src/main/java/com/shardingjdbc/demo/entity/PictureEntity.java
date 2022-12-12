package com.shardingjdbc.demo.entity;

import lombok.Data;

/**
 * @ClassName: PictureEntity
 * @Description: 测试不分库不表的表
 * @author: Ryan zhu
 * @date: 2022/12/12 10:14
 */
@Data
public class PictureEntity {
    private Integer id;
    private String title;
    private String url;
}
