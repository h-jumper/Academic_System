package com.jumper.service;

import com.jumper.pojo.UserLogin;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class userlogin {
    private ApplicationContext applicationContext;
    private UserLoginService userLoginServiceImpl;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext(new String[]{"spring/spring-dao.xml", "spring/spring-service.xml"});
       userLoginServiceImpl = (UserLoginService) applicationContext.getBean("userLoginServiceImpl");
    }

    @Test
    public void user(){
        UserLogin userLogin = userLoginServiceImpl.selectUserLoginByID(1);
        System.out.println(userLogin);
    }

}
