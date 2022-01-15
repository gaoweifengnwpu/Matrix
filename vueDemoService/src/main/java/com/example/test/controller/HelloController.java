package com.example.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

  @RequestMapping(value="/fileupload",method= RequestMethod.GET)
  public String fileupload(){
        return "fileupload";
    }
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value="/register",method= RequestMethod.GET)
    public String register(){
        return "register";
    }
}
