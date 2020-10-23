package com.jumper.mapper;


import com.jumper.pojo.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface UserLoginMapper {

    public UserLogin selectUserLoginByID(int userID);

    public UserLogin selectUserLoginByName(String userName);

    public int addUserLogin(UserLogin userLogin);

    public int updateUserLoginByID(UserLogin userLogin);

    public int updateUserLoginByName(UserLogin userLogin);

    public int deleteUserLogin(int userID);
}
