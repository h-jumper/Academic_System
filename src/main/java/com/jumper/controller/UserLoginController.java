package com.jumper.controller;

import com.jumper.pojo.UserLogin;
import com.jumper.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserLoginController {

    UserLoginService userLoginService;

    //基于Setter的依赖注入
    @Autowired
    public void setUserLoginService(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @RequestMapping("/login")
    public String login(String username,String password){
        if(username.equals("admin"))
            return "redirect:/admin/showCourse";
        else if(username.equals("student"))
            return "redirect:/student/showCourse";
        else if (username.equals("teacher"))
            return "redirect:/teacher/showCourse";
        return "/login";
    }

}
