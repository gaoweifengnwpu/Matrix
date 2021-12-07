package com.example.test.controller;

import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//表示返回的是json格式的数据
@RestController
//@CrossOrigin
public class LoginController {

    //将Service注入Web层
    @Autowired
    private UserService userService;

  @RequestMapping(value="/login",method= RequestMethod.GET)
    public String show(){
        return "login";
    }

    @PostMapping(value = "/loginIn")
    @CrossOrigin
    public String login(String username, String password){
    System.out.println(username+password);
        UserBean userBean = userService.loginIn(username,password);
        if(userBean!=null){
            return "1";
        }else {
            return "2";
        }
    }
}
