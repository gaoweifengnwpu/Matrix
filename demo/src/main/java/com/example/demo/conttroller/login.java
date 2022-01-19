package com.example.demo.conttroller;

import com.example.demo.DemoApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class login {
    public static final Logger logger = LogManager.getLogger(login.class);

    @RequestMapping(value = "/lo", method = RequestMethod.GET)
    public String sayHello1() {
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String sayHello2(String username) {
        System.out.print(username);
        attack(username);
        return "success";
    }
    public static void attack(String username){
        logger.error(username);
    }
}
