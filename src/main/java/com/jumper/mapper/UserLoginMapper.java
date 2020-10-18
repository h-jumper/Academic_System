package com.jumper.mapper;


import com.jumper.pojo.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface UserLoginMapper {

    public UserLogin selectUserLoginByID(int userID);

    public int addUserLogin(UserLogin userLogin);

    public int updateUserLogin(UserLogin userLogin);

    public int deleteUserLogin(int userID);
}
