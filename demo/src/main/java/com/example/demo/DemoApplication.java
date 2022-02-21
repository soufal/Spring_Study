package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//本身就是一个Spring组件
//程序的主入口--标注这个类是一个springboot的应用。
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //run方法
        SpringApplication.run(DemoApplication.class, args);
    }

}
