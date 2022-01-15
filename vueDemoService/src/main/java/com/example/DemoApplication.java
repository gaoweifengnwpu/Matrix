package com.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(scanBasePackages={"com.example.test.controller"})
@SpringBootApplication
//使用MapperScan批量扫描所有的Mapper接口；
@MapperScan("com.example.test.mapper")
class DemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
  /**
   * 配置跨域访问的过滤器
   * @return
   */
//  @Bean
//  public FilterRegistrationBean registerFilter(){
//    FilterRegistrationBean bean = new FilterRegistrationBean();
//    bean.addUrlPatterns("/*");
//    bean.setFilter(new CrosFilter());
//    return bean;
//  }
}
