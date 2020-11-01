package com.jumper.pojo;

public class SelectedCourse {
    private Integer courseID;
    private Integer studentID;
    private Integer mark;

    public SelectedCourse(Integer courseID, Integer studentID, Integer mark) {
        this.courseID = courseID;
        this.studentID = studentID;
        this.mark = mark;
    }

    public SelectedCourse() {
    }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(Integer courseID) {
        this.courseID = courseID;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}
