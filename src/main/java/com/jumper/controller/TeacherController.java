package com.jumper.controller;

import com.jumper.pojo.*;
import com.jumper.service.CourseService;
import com.jumper.service.SelectedCourseService;
import com.jumper.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    UserLoginService userLoginService;

    @Autowired
    CourseService courseService;

    @Autowired
    SelectedCourseService selectedCourseService;

    @RequestMapping("/teacher/showCourse")
    public String toShowCourse(Model model, Integer page, HttpSession session){
        Page pages = new Page();
        Subject subject = SecurityUtils.getSubject();
        String userName = (String) subject.getPrincipal();
        int countCourse = courseService.countCourseByTeacherID(userName);
        pages.setTotalCount(countCourse);
        if(page == null || page == 0){
            pages.setCurrentPageNo(1);
        }else
            pages.setCurrentPageNo(page);
        List<Course> courseList = courseService.selectTeacherCourse(userName,pages);
        session.setAttribute("countCourse",countCourse);
        model.addAttribute("courseList",courseList);
        model.addAttribute("page",pages);
        return "teacher/showCourse";
    }

    @RequestMapping("/teacher/selectCourse")
    public String selectCourse(Model model,String courseName){
        Subject subject = SecurityUtils.getSubject();
        String userName = (String) subject.getPrincipal();
        List<Course> courseList = courseService.selectTeacherCourseByName(userName,courseName);
        model.addAttribute("courseList",courseList);
        return "teacher/showCourse";
    }

    @RequestMapping("/teacher/gradeCourse")
    public String gradeCourse(Model model,int id){
        List<StudentMark> studentMarks = selectedCourseService.selectStudentMarkByCourseID(id);
        model.addAttribute("studentMarks",studentMarks);
        return "teacher/showGrade";
    }

    @GetMapping("/teacher/mark")
    public String toMark(Model model,int userID,int courseID){
        StudentMark studentMark = selectedCourseService.selectStudentMark(userID, courseID);
        model.addAttribute("studentMark",studentMark);
        return "teacher/mark";
    }

    @PostMapping("/teacher/mark")
    public String mark(Model model,String userID,String courseID,int mark){
        SelectedCourse selectedCourse = new SelectedCourse(Integer.parseInt(courseID), Integer.parseInt(userID), mark);
        selectedCourseService.updateMark(selectedCourse);
        List<StudentMark> studentMarks = selectedCourseService.selectStudentMarkByCourseID(Integer.parseInt(courseID));
        model.addAttribute("studentMarks",studentMarks);
        return "teacher/showGrade";
    }

    @GetMapping("/teacher/passwordRest")
    public String toPasswordRest(){
        return "teacher/passwordRest";
    }

    @PostMapping("/teacher/passwordRest")
    public String passwordRest(Model model, String oldPassword, String password){
        Subject subject = SecurityUtils.getSubject();
        String userName = (String) subject.getPrincipal();
        UserLogin userLogin = userLoginService.selectUserLoginByName(userName);
        if (userLogin.getPassword().equals(oldPassword)){
            UserLogin login = new UserLogin();
            login.setUserName(userName);
            login.setPassword(password);
            login.setRole(userLogin.getRole());
            userLoginService.updateUserLoginByName(login);
            return "teacher/passwordRest";
        }else{
            model.addAttribute("message","旧密码错误");
            return "error";
        }
    }

    @RequestMapping("/teacher/passwordRestCheck")
    @ResponseBody
    public String passwordRestCheck(String oldPassword){
        Subject subject = SecurityUtils.getSubject();
        String userName = (String) subject.getPrincipal();
        UserLogin userLogin = userLoginService.selectUserLoginByName(userName);
        if (userLogin.getPassword().equals(oldPassword))
            return "true";
        else
            return "false";
    }
}
