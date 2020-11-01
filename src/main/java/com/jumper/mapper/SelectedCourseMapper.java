package com.jumper.mapper;

import com.jumper.pojo.SelectedCourse;
import com.jumper.pojo.StudentMark;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Marker;

import java.util.List;

public interface SelectedCourseMapper {

    public int insertSelectedCourse(SelectedCourse selectedCourse);

    public int deleteSelectedCourse(SelectedCourse selectedCourse);

    public List<StudentMark> selectStudentMarkByCourseID(int courseID);

    public StudentMark selectStudentMark(@Param("userID")int userID,@Param("courseID")int courseID);

    public int updateMark(SelectedCourse selectedCourse);

    public int countStudentChoose(int userID);
}
