package com.jumper.pojo;

import java.util.Date;

public class StudentMark {

    private int userID;
    private String userName;
    private int courseID;
    private Integer mark;

    public StudentMark() {
    }

    public StudentMark(int userID, String userName, int courseID, Integer mark) {
        this.userID = userID;
        this.userName = userName;
        this.courseID = courseID;
        this.mark = mark;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "StudentMark{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", mark=" + mark +
                '}';
    }

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

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public StudentMark(int userID, String userName, Integer mark) {
        this.userID = userID;
        this.userName = userName;
        this.mark = mark;
    }
}
