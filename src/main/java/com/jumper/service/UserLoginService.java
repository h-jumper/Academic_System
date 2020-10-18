package com.jumper.service;

import com.jumper.pojo.UserLogin;

public interface UserLoginService {
    public UserLogin selectUserLoginByID(int userID);

    public int addUserLogin(UserLogin userLogin);

    public int updateUserLogin(UserLogin userLogin);

    public int deleteUserLogin(int userID);
}
