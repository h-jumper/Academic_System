package com.jumper.controller;

import com.jumper.pojo.*;
import com.jumper.service.*;
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
public class AdminController {

    @Autowired
    CourseService courseService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    CollegeService collegeService;

    @Autowired
    StudentService studentService;

    @Autowired
    UserLoginService userLoginService;

    @Autowired
    SelectedCourseService selectedCourseService;

    //========================课程============================
    @RequestMapping("/admin/showCourse")
    public String toShowCourse(Model model, Integer page, HttpSession session){
        Page pages = new Page();
        int courseCount = courseService.courseCount();
        int studentCount = studentService.studentCount();
        int teacherCount = teacherService.teacherCount();
        pages.setTotalCount(courseCount);
        if(page == null || page == 0){
            pages.setCurrentPageNo(1);
        }else
            pages.setCurrentPageNo(page);
        List<Course> courseList = courseService.selectCourseByPage(pages);
        session.setAttribute("courseCount",courseCount);
        session.setAttribute("studentCount",studentCount);
        session.setAttribute("teacherCount",teacherCount);
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

    @RequestMapping("/admin/addCourseCheck")
    @ResponseBody
    public String addCourseCheck(int courseID){
        Course course = courseService.selectCourseByID(courseID);
        if (course!=null)
            return "false";
        else
            return "true";
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

    @RequestMapping("/admin/removeCourseCheck")
    @ResponseBody
    public String removeCourseCheck(int courseID){
        List<StudentMark> studentMarks = selectedCourseService.selectStudentMarkByCourseID(courseID);
        if (studentMarks.isEmpty())
            return "false";
        else
            return "true";
    }

    @RequestMapping("/admin/selectCourse")
    public String selectCourse(Model model,String courseName){
        List<Course> courseList = courseService.selectCourseByName(courseName);
        model.addAttribute("courseList",courseList);
        return "admin/showCourse";
    }

    //========================学生============================
    @RequestMapping("/admin/showStudent")
    public String toShowStudent(Model model,Integer page,HttpSession session){
        Page pages = new Page();
        int count = studentService.studentCount();
        pages.setTotalCount(count);
        if(page == null || page == 0){
            pages.setCurrentPageNo(1);
        }else
            pages.setCurrentPageNo(page);
        List<Student> students = studentService.selectStudentByPage(pages);
        session.setAttribute("studentCount",count);
        model.addAttribute("page",pages);
        model.addAttribute("studentList",students);
        return "admin/showStudent";
    }

    @GetMapping("/admin/addStudent")
    public String toAddStudent(Model model){
        List<College> colleges = collegeService.selectAllCollege();
        model.addAttribute("collegeList",colleges);
        return "admin/addStudent";
    }

    @PostMapping("/admin/addStudent")
    public String addStudent(Model model,Student student){
        if (studentService.addStudent(student)) {
            UserLogin userLogin = new UserLogin();
            userLogin.setRole(2);
            userLogin.setUserName(Integer.toString(student.getUserID()));
            userLoginService.addUserLogin(userLogin);
            return "redirect:/admin/showStudent";
        }else{
            model.addAttribute("message","学号重复");
            return "error";
        }
    }

    @RequestMapping("/admin/addStudentCheck")
    @ResponseBody
    public String addStudentCheck(int userID){
        UserLogin userLogin = userLoginService.selectUserLoginByName(String.valueOf(userID));
        if (userLogin!=null)
            return "false";
        else
            return "true";
    }

    @GetMapping("/admin/editStudent")
    public String toEditStudent(Model model,int id){
        List<College> colleges = collegeService.selectAllCollege();
        Student student = studentService.selectStudentByID(id);
        model.addAttribute("collegeList",colleges);
        model.addAttribute("student",student);
        return "admin/editStudent";
    }

    @PostMapping("/admin/editStudent")
    public String editStudent(Student student){
        studentService.updateStudent(student);
        return "redirect:/admin/showStudent";
    }

    @GetMapping("/admin/removeStudent")
    public String removeStudent(Model model,int id){
        studentService.deleteStudent(id);
        userLoginService.deleteUserLoginByUserName(String.valueOf(id));
        return "redirect:/admin/showStudent";
    }

    @RequestMapping("/admin/removeStudentCheck")
    @ResponseBody
    public String removeStudentCheck(int userID){
        int count = selectedCourseService.countStudentChoose(userID);
        if (count==0)
            return "false";
        else
            return "true";
    }

    @RequestMapping("/admin/selectStudent")
    public String selectStudent(Model model,String studentName){
        List<Student> students = studentService.selectStudentByName(studentName);
        model.addAttribute("studentList",students);
        return "admin/showStudent";
    }

    //========================老师============================
    @RequestMapping("/admin/showTeacher")
    public String toShowTeacher(Model model,Integer page,HttpSession session){
        Page pages = new Page();
        int teacherCount = teacherService.teacherCount();
        pages.setTotalCount(teacherCount);
        if(page == null || page == 0){
            pages.setCurrentPageNo(1);
        }else
            pages.setCurrentPageNo(page);
        List<Teacher> teachers = teacherService.selectTeacherByPage(pages);
        session.setAttribute("teacherCount",teacherCount);
        model.addAttribute("page",pages);
        model.addAttribute("teacherList",teachers);
        return "admin/showTeacher";
    }

    @GetMapping("/admin/addTeacher")
    public String toAddTeacher(Model model){
        List<College> colleges = collegeService.selectAllCollege();
        model.addAttribute("collegeList",colleges);
        return "admin/addTeacher";
    }

    @PostMapping("/admin/addTeacher")
    public String addTeacher(Model model,Teacher teacher){
        if (teacherService.addTeacher(teacher)) {
            UserLogin userLogin = new UserLogin();
            userLogin.setRole(1);
            userLogin.setUserName(Integer.toString(teacher.getUserID()));
            userLoginService.addUserLogin(userLogin);
            return "redirect:/admin/showTeacher";
        }else{
            model.addAttribute("message","工号重复");
            return "error";
        }
    }

    @RequestMapping("/admin/addTeacherCheck")
    @ResponseBody
    public String addTeacherCheck(int userID){
        UserLogin userLogin = userLoginService.selectUserLoginByName(String.valueOf(userID));
        if (userLogin!=null)
            return "false";
        else
            return "true";
    }

    @GetMapping("/admin/editTeacher")
    public String toEditTeacher(Model model,int id){
        List<College> colleges = collegeService.selectAllCollege();
        Teacher teacher = teacherService.selectTeacherByID(id);
        model.addAttribute("collegeList",colleges);
        model.addAttribute("teacher",teacher);
        return "admin/editTeacher";
    }

    @PostMapping("/admin/editTeacher")
    public String editStudent(Teacher teacher){
        teacherService.updateTeacher(teacher);
        return "redirect:/admin/showTeacher";
    }

    @GetMapping("/admin/removeTeacher")
    public String removeTeacher(Model model,int id){
        if (teacherService.deleteTeacher(id)) {
            userLoginService.deleteUserLoginByUserName(String.valueOf(id));
            return "redirect:/admin/showTeacher";
        } else{
            model.addAttribute("message","请先删除此老师的课程");
            return "error";
        }
    }

    @RequestMapping("/admin/removeTeacherCheck")
    @ResponseBody
    public String removeTeacherCheck(int userID){
        List<Course> courseList = courseService.selectCourseByTeacherID(userID);
        if (courseList.isEmpty())
            return "false";
        else
            return "true";
    }

    @RequestMapping("/admin/selectTeacher")
    public String selectTeacher(Model model,String teacherName){
        List<Teacher> teachers = teacherService.selectTeacherByName(teacherName);
        model.addAttribute("teacherList",teachers);
        return "admin/showTeacher";
    }

    //========================修改密码============================
    @GetMapping("/admin/userPasswordRest")
    public String toUserPasswordRest(){
        return "admin/userPasswordRest";
    }

    @PostMapping("/admin/userPasswordRest")
    public String UserPasswordRest(Model model,UserLogin userLogin){
        UserLogin user = userLoginService.selectUserLoginByName(userLogin.getUserName());
        userLogin.setRole(user.getRole());
        boolean flag = userLoginService.updateUserLoginByName(userLogin);
        if (flag)
            return "admin/userPasswordRest";
        else{
            model.addAttribute("message","没有此用户");
            return "error";
        }
    }

    @RequestMapping("/admin/usePasswordRestCheck")
    @ResponseBody
    public String usePasswordRestCheck(String userName){
        UserLogin userLogin = userLoginService.selectUserLoginByName(userName);
        if (userLogin==null)
            return "false";
        else
            return "true";
    }

    @GetMapping("/admin/passwordRest")
    public String toPasswordRest(){
        return "admin/passwordRest";
    }

    @PostMapping("/admin/passwordRest")
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
            return "admin/passwordRest";
        }else{
            model.addAttribute("message","旧密码错误");
            return "error";
        }
    }

    @RequestMapping("/admin/passwordRestCheck")
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
