package com.jumper.controller;

import com.jumper.service.UserLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {

    UserLoginService userLoginService;

    //基于Setter的依赖注入
    @Autowired
    public void setUserLoginService(UserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @RequestMapping("/login")
    public String login(Model model,String username, String password, HttpSession session) {
        //Shiro实现登录
        Subject subject = SecurityUtils.getSubject();
        //将用户名，密码存入token中
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        String msg;
        try {
            //登录进入Realm中doGetAuthenticationInfo方法
            subject.login(token);
            //查询用户角色信息进入Realm中doGetAuthorizationInfo方法
            if (subject.hasRole("admin")) {
                return "redirect:/admin/showCourse";
            } else if (subject.hasRole("student")) {
                return "redirect:/student/showCourse";
            } else if (subject.hasRole("teacher")) {
                return "redirect:/teacher/showCourse";
            }
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误";
            model.addAttribute("message", msg);
        } catch (UnknownAccountException e) {
            msg = "帐号不存在";
            model.addAttribute("message", msg);
        }
        return "forward:login.jsp";
    }

}
