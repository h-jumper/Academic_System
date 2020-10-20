package com.jumper.controller;

import com.jumper.pojo.College;
import com.jumper.pojo.Course;
import com.jumper.pojo.Page;
import com.jumper.pojo.Teacher;
import com.jumper.service.CollegeService;
import com.jumper.service.CourseService;
import com.jumper.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    CourseService courseService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    CollegeService collegeService;

    @RequestMapping("/admin/showCourse")
    public String toShowCourse(Model model,Integer page){
        Page pages = new Page();
        pages.setTotalCount(courseService.courseCount());
        if(page == null || page == 0){
            pages.setCurrentPageNo(1);
        }else
            pages.setCurrentPageNo(page);
        List<Course> courseList = courseService.selectCourseByPage(pages);
        model.addAttribute("page",pages);
        model.addAttribute("courseList",courseList);
        return "admin/showCourse";
    }

    @GetMapping("/admin/addCourse")
    public String toAddCourse(Model model){
        List<Teacher> teachers = teacherService.selectAllTeacher();
        List<College> colleges = collegeService.selectAllCollege();
        model.addAttribute("teacherList",teachers);
        model.addAttribute("collegeList",colleges);
        return "admin/addCourse";
    }

    @PostMapping("/admin/addCourse")
    public String addCourse(Model model,Course course){
        if (courseService.addCourse(course))
            return "redirect:/admin/showCourse";
        else{
            model.addAttribute("message","课程号重复");
            return "error";
        }
    }

    @GetMapping("/admin/editCourse")
    public String toEditCourse(Model model,int id){
        List<Teacher> teachers = teacherService.selectAllTeacher();
        List<College> colleges = collegeService.selectAllCollege();
        Course course = courseService.selectCourseByID(id);
        model.addAttribute("teacherList",teachers);
        model.addAttribute("collegeList",colleges);
        model.addAttribute("course",course);
        return "admin/editCourse";
    }

    @PostMapping("/admin/editCourse")
    public String editCourse(Course course){
        courseService.updateCourse(course);
        return "redirect:/admin/showCourse";
    }

    @GetMapping("/admin/removeCourse")
    public String removeCourse(int id){
        courseService.deleteCourse(id);
        return "redirect:/admin/showCourse";
    }

    @RequestMapping("/admin/selectCourse")
    public String selectCourse(Model model,Integer page,String courseName){
        Page pages = new Page();
        pages.setTotalCount(courseService.countCourseByName(courseName));
        if(page == null || page == 0){
            pages.setCurrentPageNo(1);
        }else
            pages.setCurrentPageNo(page);
        List<Course> courseList = courseService.selectCourseByName(courseName,pages);
        model.addAttribute("courseName",courseName);
        model.addAttribute("selectPage",pages);
        model.addAttribute("courseList",courseList);
        return "admin/showCourse";
    }

    @RequestMapping("/admin/showStudent")
    public String toShowStudent(){
        return "admin/showStudent";
    }

    @RequestMapping("/admin/showTeacher")
    public String toShowTeacher(){
        return "admin/showTeacher";
    }

    @RequestMapping("/admin/userPasswordRest")
    public String toUserPasswordRest(){
        return "admin/userPasswordRest";
    }

    @RequestMapping("/admin/passwordRest")
    public String toPasswordRest(){
        return "admin/passwordRest";
    }
}
