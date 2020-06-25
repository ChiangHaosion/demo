package com.dossen.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HaosionChiang
 */
@SpringBootApplication
@MapperScan("com.dossen.demo.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        System.out.println("hello world");
        SpringApplication.run(DemoApplication.class, args);
    }

}
