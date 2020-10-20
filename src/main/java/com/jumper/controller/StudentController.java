package com.jumper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/student/showCourse")
    public String toShowCourse(){
        return "student/showCourse";
    }

    @RequestMapping("/student/selectedCourse")
    public String toSelectedCourse(){
        return "student/selectCourse";
    }

    @RequestMapping("/student/overCourse")
    public String toOverCourse(){
        return "student/overCourse";
    }

    @RequestMapping("/student/passwordRest")
    public String toPasswordRest(){
        return "student/passwordRest";
    }
}
