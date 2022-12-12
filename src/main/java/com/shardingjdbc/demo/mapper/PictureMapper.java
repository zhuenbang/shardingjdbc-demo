package com.shardingjdbc.demo.mapper;

import com.shardingjdbc.demo.entity.PictureEntity;

/**
 * @ClassName: PictureMapper
 * @Description: 测试图片mapper
 * @author: Ryan zhu
 * @date: 2022/12/12 10:21
 */
public interface PictureMapper {

    int save(PictureEntity picture);
}
