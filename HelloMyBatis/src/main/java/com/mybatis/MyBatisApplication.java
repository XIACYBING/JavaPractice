package com.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: ideaWorkspace
 * @description: HelloMyBatis启动类
 * @author: wang.yubin
 * @create: 2019/06/04
 */
@SpringBootApplication
public class MyBatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisApplication.class);
        System.out.println("MyBatisApplication...");
    }

}
