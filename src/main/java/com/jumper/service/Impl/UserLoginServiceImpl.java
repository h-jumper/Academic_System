package com.jumper.service.Impl;

import com.jumper.mapper.UserLoginMapper;
import com.jumper.pojo.UserLogin;
import com.jumper.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements UserLoginService {

    //基于字段的依赖注入
    @Autowired
    UserLoginMapper userLoginMapper;

    @Override
    public UserLogin selectUserLoginByID(int userID) {
        return userLoginMapper.selectUserLoginByID(userID);
    }

    @Override
    public UserLogin selectUserLoginByName(String userName) {
        return userLoginMapper.selectUserLoginByName(userName);
    }

    @Override
    public int addUserLogin(UserLogin userLogin) {
        return userLoginMapper.addUserLogin(userLogin);
    }

    @Override
    public boolean updateUserLoginByID(UserLogin userLogin) {
        if(userLoginMapper.selectUserLoginByID(userLogin.getUserID())!=null) {
            userLoginMapper.updateUserLoginByID(userLogin);
            return true;
        }else
            return false;
    }

    @Override
    public boolean updateUserLoginByName(UserLogin userLogin) {
        if(userLoginMapper.selectUserLoginByName(userLogin.getUserName())!=null) {
            userLoginMapper.updateUserLoginByName(userLogin);
            return true;
        }else
            return false;
    }

    @Override
    public int deleteUserLogin(int userID) {
        return userLoginMapper.deleteUserLogin(userID);
    }
}
