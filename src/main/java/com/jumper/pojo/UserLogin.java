package com.jumper.pojo;

import org.springframework.stereotype.Repository;


public class UserLogin {

    private int userID;
    private String userName;
    private String password;
    private int role;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public UserLogin() {
    }

    public UserLogin(int userID, String userName, String password, int role) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
