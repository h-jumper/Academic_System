package com.jumper.pojo;

public class Course {

    private int courseID;
    private String courseName;
    private int teacherID;
    private String teacherName;
    private String courseTime;
    private String classRoom;
    private int courseWeek;
    private String courseType;
    private int collegeID;
    private int score;
    private int mark;

    public Course(int courseID, String courseName, int teacherID, String teacherName, String courseTime, String classRoom, int courseWeek, String courseType, int collegeID, int score, int mark) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.courseTime = courseTime;
        this.classRoom = classRoom;
        this.courseWeek = courseWeek;
        this.courseType = courseType;
        this.collegeID = collegeID;
        this.score = score;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID=" + courseID +
                ", courseName='" + courseName + '\'' +
                ", teacherID=" + teacherID +
                ", teacherName='" + teacherName + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", classRoom='" + classRoom + '\'' +
                ", courseWeek=" + courseWeek +
                ", courseType='" + courseType + '\'' +
                ", collegeID=" + collegeID +
                ", score=" + score +
                ", mark=" + mark +
                '}';
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Course() {
    }

    public Course(int courseID, String courseName, int teacherID, String teacherName, String courseTime, String classRoom, int courseWeek, String courseType, int collegeID, int score) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.courseTime = courseTime;
        this.classRoom = classRoom;
        this.courseWeek = courseWeek;
        this.courseType = courseType;
        this.collegeID = collegeID;
        this.score = score;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public int getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(int courseWeek) {
        this.courseWeek = courseWeek;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
