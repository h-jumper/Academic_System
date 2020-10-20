package com.jumper.mapper;

import com.jumper.pojo.UserLogin;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class mapperTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-dao.xml");
    }

    @Test
    public void findByPaging() throws Exception {
        UserLoginMapper userLoginMapper = (UserLoginMapper) applicationContext.getBean("userLoginMapper");
        UserLogin userLogin = userLoginMapper.selectUserLoginByID(1);
        System.out.println(userLogin);
    }

}
