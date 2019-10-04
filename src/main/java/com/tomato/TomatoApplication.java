package com.tomato;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.tomato.mapper")
@SpringBootApplication
public class TomatoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TomatoApplication.class, args);
    }

}
