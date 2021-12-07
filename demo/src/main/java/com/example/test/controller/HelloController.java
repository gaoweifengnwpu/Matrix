package com.example.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

  @RequestMapping(value="/",method= RequestMethod.GET)
  public String sayHello(){
        return "index";
    }
}
