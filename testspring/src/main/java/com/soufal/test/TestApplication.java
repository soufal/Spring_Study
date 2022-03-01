package com.soufal.test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: Spring启动类
 * @author: wuyifan
 * @create: 2021/11/12 13:56
 */


@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
        System.out.println("TestApplication start success...");
    }
}
