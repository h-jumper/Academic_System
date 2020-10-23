package com.jumper.service;

import com.jumper.pojo.UserLogin;

public interface UserLoginService {
    public UserLogin selectUserLoginByID(int userID);

    public UserLogin selectUserLoginByName(String userName);

    public int addUserLogin(UserLogin userLogin);

    public boolean updateUserLoginByID(UserLogin userLogin);

    public boolean updateUserLoginByName(UserLogin userLogin);

    public int deleteUserLogin(int userID);
}
