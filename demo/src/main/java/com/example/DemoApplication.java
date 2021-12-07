package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages={"com.example.test.controller"})
@SpringBootApplication
//使用MapperScan批量扫描所有的Mapper接口；
@MapperScan("com.example.test.mapper")
class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

}
