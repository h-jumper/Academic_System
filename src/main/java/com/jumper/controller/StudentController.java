package com.jumper.controller;

import com.jumper.pojo.Course;
import com.jumper.pojo.Page;
import com.jumper.pojo.SelectedCourse;
import com.jumper.pojo.UserLogin;
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
public class StudentController {

    @Autowired
    CourseService courseService;

    @Autowired
    SelectedCourseService selectedCourseService;

    @Autowired
    UserLoginService userLoginService;

    @RequestMapping("/student/showCourse")
    public String toShowCourse(Model model, Integer page,HttpSession session){
        Page pages = new Page();
        Subject subject = SecurityUtils.getSubject();
        String userName = (String) subject.getPrincipal();
        int noChooseCourse = courseService.countNoChooseCourse(userName);
        int studentChooseCourse = courseService.countStudentChooseCourse(userName);
        int studentFinishCourse = courseService.countStudentFinishCourse(userName);
        pages.setTotalCount(noChooseCourse);
        if(page == null || page == 0){
            pages.setCurrentPageNo(1);
        }else
            pages.setCurrentPageNo(page);
        List<Course> courseList = courseService.selectNoChooseCourse(userName,pages);
        session.setAttribute("noChooseCourse",noChooseCourse);
        session.setAttribute("studentChooseCourse",studentChooseCourse);
        session.setAttribute("studentFinishCourse",studentFinishCourse);
        model.addAttribute("courseList",courseList);
        model.addAttribute("page",pages);
        return "student/showCourse";
    }

    @RequestMapping("/student/selectCourse")
    public String selectCourse(Model model,String courseName){
        Subject subject = SecurityUtils.getSubject();
        String userName = (String) subject.getPrincipal();
        List<Course> courseList = courseService.selectNoChooseCourseByName(userName, courseName);
        model.addAttribute("courseList",courseList);
        return "student/showCourse";
    }

    @RequestMapping("/student/chooseCourse")
    public String chooseCourse(int id){
        Subject subject = SecurityUtils.getSubject();
        String userName = (String) subject.getPrincipal();
        SelectedCourse selectedCourse = new SelectedCourse();
        selectedCourse.setCourseID(id);
        selectedCourse.setStudentID(Integer.parseInt(userName));
        selectedCourseService.insertSelectedCourse(selectedCourse);
        return "redirect:/student/showCourse";
    }

    @RequestMapping("/student/selectedCourse")
    public String toSelectedCourse(Model model, Integer page,HttpSession session){
        Page pages = new Page();
        Subject subject = SecurityUtils.getSubject();
        String userName = (String) subject.getPrincipal();
        int studentChooseCourse = courseService.countStudentChooseCourse(userName);
        int noChooseCourse = courseService.countNoChooseCourse(userName);
        pages.setTotalCount(studentChooseCourse);
        if(page == null || page == 0){
            pages.setCurrentPageNo(1);
        }else
            pages.setCurrentPageNo(page);
        List<Course> chooseCourse = courseService.selectStudentChooseCourse(userName,pages);
        session.setAttribute("noChooseCourse",noChooseCourse);
        session.setAttribute("studentChooseCourse",studentChooseCourse);
        model.addAttribute("chooseCourse",chooseCourse);
        model.addAttribute("page",pages);
        return "student/selectCourse";
    }

    @RequestMapping("/student/outCourse")
    public String outCourse(int id){
        Subject subject = SecurityUtils.getSubject();
        String userName = (String) subject.getPrincipal();
        SelectedCourse selectedCourse = new SelectedCourse();
        selectedCourse.setCourseID(id);
        selectedCourse.setStudentID(Integer.parseInt(userName));
        selectedCourseService.deleteSelectedCourse(selectedCourse);
        return "redirect:/student/selectedCourse";
    }

    @RequestMapping("/student/overCourse")
    public String toOverCourse(Model model, Integer page,HttpSession session){
        Page pages = new Page();
        Subject subject = SecurityUtils.getSubject();
        String userName = (String) subject.getPrincipal();
        int courseCount = courseService.countStudentFinishCourse(userName);
        pages.setTotalCount(courseCount);
        if(page == null || page == 0){
            pages.setCurrentPageNo(1);
        }else
            pages.setCurrentPageNo(page);
        List<Course> finishCourse = courseService.selectStudentFinishCourse(userName,pages);
        session.setAttribute("studentFinishCourse",courseCount);
        model.addAttribute("finishCourse",finishCourse);
        model.addAttribute("page",pages);
        return "student/overCourse";
    }

    @GetMapping("/student/passwordRest")
    public String toPasswordRest(){
        return "student/passwordRest";
    }

    @PostMapping("/student/passwordRest")
    public String passwordRest(Model model,String oldPassword,String password){
        Subject subject = SecurityUtils.getSubject();
        String userName = (String) subject.getPrincipal();
        UserLogin userLogin = userLoginService.selectUserLoginByName(userName);
        if (userLogin.getPassword().equals(oldPassword)){
            UserLogin login = new UserLogin();
            login.setUserName(userName);
            login.setPassword(password);
            login.setRole(userLogin.getRole());
            userLoginService.updateUserLoginByName(login);
            return "student/passwordRest";
        }else{
            model.addAttribute("message","旧密码错误");
            return "error";
        }
    }

    @RequestMapping("/student/passwordRestCheck")
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
