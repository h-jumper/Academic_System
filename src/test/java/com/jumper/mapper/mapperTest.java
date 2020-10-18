package com.jumper.mapper;

import com.jumper.mapper.UserLoginMapper;
import com.jumper.pojo.UserLogin;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class mapperTest {

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring-dao.xml");
    }

    @Test
    public void findByPaging() throws Exception {
        UserLoginMapper userLoginMapper = (UserLoginMapper) applicationContext.getBean("userLoginMapper");
        UserLogin userLogin = userLoginMapper.selectUserLoginByID(1);
        System.out.println(userLogin);
    }

}
