package com.jumper.pojo;

import java.util.Date;

public class Student {

    private int userID;
    private String userName;
    private String sex;
    private Date birthYear;
    private Date grade;
    private int collegeID;
    private String collegeName;


    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", birthYear=" + birthYear +
                ", grade=" + grade +
                ", collegeID=" + collegeID +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
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
