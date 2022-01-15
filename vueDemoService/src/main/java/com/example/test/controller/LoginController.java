package com.example.test.controller;

import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

//表示返回的是json格式的数据
@RestController
//@CrossOrigin
public class LoginController {

    //将Service注入Web层
    @Autowired
    private UserService userService;

    //  sqlmap -r sql.txt  -p username --dbs
    @PostMapping(value = "/loginIn")
    @CrossOrigin
    public String login(String username, String password) {
//    String username=request.getParameter("username");
//    String password=request.getParameter("password");
        System.out.println(username + '/' + password);
        UserBean userBean = userService.loginIn(username, password);
        if (userBean != null) {
            return "login success";
        } else {
            return "login fail";
        }
    }

    @PostMapping(value = "/register")
    @CrossOrigin
    public String register(String username, String password) {
//    String username=request.getParameter("username");
//    String password=request.getParameter("password");
        System.out.println(username + password);
        UserBean user = new UserBean();
        user.setName(username);
        user.setPassword(password);
        int id = userService.register(user);
        return "register success";
    }
}
