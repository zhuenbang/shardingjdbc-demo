package com.shardingjdbc.demo.entity;

import lombok.Data;

/**
 * @ClassName: UserInfoEntity
 * @Description: 用户实体
 * @author: Ryan zhu
 * @date: 2022/12/9 14:06
 */
@Data
public class UserInfoEntity {
    private Integer id;

    private String userId;

    private String userName;
}
