package com.jumper.pojo;

public class College {

    private int collegeID;
    private String collegeName;

    @Override
    public String toString() {
        return "College{" +
                "collegeID=" + collegeID +
                ", collegeName='" + collegeName + '\'' +
                '}';
    }

    public int getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(int collegeID) {
        this.collegeID = collegeID;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public College() {
    }
}
