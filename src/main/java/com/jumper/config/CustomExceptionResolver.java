package com.jumper.config;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *    全局异常处理器
 *    springmvc提供一个HandlerExceptionResolver接口
 *      只要实现该接口，并配置到spring 容器里，该类就能
 *      成为默认全局异常处理类
 *
 *   全局异常处理器只有一个，配置多个也没用。
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();


        if (e instanceof UnknownAccountException) {
            //用户名错误异常
            modelAndView.addObject("message", "没有该用户");
            modelAndView.setViewName("error");
            return modelAndView;
        } else if (e instanceof IncorrectCredentialsException) {
            //用户名错误异常
            modelAndView.addObject("message", "密码错误");
            modelAndView.setViewName("error");
            return modelAndView;
        } else if (e instanceof UnauthorizedException){
            modelAndView.addObject("message", "没有授权");
            modelAndView.setViewName("error");
            return modelAndView;
        }

        //错误信息传递和错误页面跳转
        modelAndView.addObject("message", "未知错误");
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
