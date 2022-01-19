package com.example.test;

import com.example.test.bean.UserBean;
import com.example.test.service.UserService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

//https://www.cnblogs.com/nice0e3/p/13552644.html
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {
    //    这是为对象声明了一个对象引用object，称为软引用，jvm并不会为对象开辟空间；
    //ObjectMapper objectMapper = null;
    ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        List<UserBean> list = userService.findUsers();

        try {
            System.out.println("gwf");
            System.out.println(list.get(0).getId());
            System.out.println(objectMapper.writeValueAsString(list));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

}
