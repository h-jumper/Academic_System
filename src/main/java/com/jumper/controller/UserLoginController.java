package com.jumper.controller;

import com.jumper.pojo.UserLogin;
import com.jumper.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @RequestMapping("/user")
    public String userLogin(){
        System.out.println(userLoginService.selectUserLoginByID(1));
        return "user";
    }

    @RequestMapping("/test")
    public String test(){
        return "jumper ok";
    }

    @RequestMapping("/test1")
    public String test1(){
        return "jumper ok1";
    }

    @RequestMapping("/test2")
    public String test2(){
        return "jumper ok2";
    }
}
