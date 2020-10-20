package com.jumper.pojo;

import java.util.Date;

public class Teacher {

    private int userID;
    private String userName;
    private String sex;
    private Date birthYear;
    private String degree;
    private String title;
    private Date grade;
    private int collegeID;

    public Teacher() {
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthYear=" + birthYear +
                ", degree='" + degree + '\'' +
                ", title='" + title + '\'' +
                ", grade=" + grade +
                ", collegeID=" + collegeID +
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Date birthYear) {
        this.birthYear = birthYear;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getGrade() {
        return grade;
    }

    public void setGrade(Date grade) {
        this.grade = grade;
    }

    public int getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }
}
