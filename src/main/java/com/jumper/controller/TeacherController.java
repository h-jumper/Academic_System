package com.jumper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {

    @RequestMapping("/teacher/showCourse")
    public String toShowCourse(){
        return "teacher/showCourse";
    }

    @RequestMapping("/teacher/passwordRest")
    public String toPasswordRest(){
        return "teacher/passwordRest";
    }
}
