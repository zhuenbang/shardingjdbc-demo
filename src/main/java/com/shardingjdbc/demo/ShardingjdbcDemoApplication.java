package com.shardingjdbc.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.shardingjdbc.demo.mapper"})
public class ShardingjdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingjdbcDemoApplication.class, args);
    }

}
