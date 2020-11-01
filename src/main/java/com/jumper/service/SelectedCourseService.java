package com.jumper.service;

import com.jumper.pojo.SelectedCourse;
import com.jumper.pojo.StudentMark;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectedCourseService {

    public int insertSelectedCourse(SelectedCourse selectedCourse);

    public int deleteSelectedCourse(SelectedCourse selectedCourse);

    public List<StudentMark> selectStudentMarkByCourseID(int courseID);

    public StudentMark selectStudentMark(int userID, int courseID);

    public int updateMark(SelectedCourse selectedCourse);

    public int countStudentChoose(int userID);
}
