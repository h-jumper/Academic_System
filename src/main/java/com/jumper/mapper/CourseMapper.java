package com.jumper.mapper;

import com.jumper.pojo.Course;
import com.jumper.pojo.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {

    public List<Course> selectCourseByPage(Page page);

    public int courseCount();

    public Course selectCourseByID(int courseID);

    public int addCourse(Course course);

    public int updateCourse(Course course);

    public int deleteCourse(int courseID);

    public List<Course> selectCourseByName(@Param("courseName")String courseName);

    public int countCourseByName(String courseName);

    public List<Course> selectCourseByTeacherID(int teacherID);

    public List<Course> selectNoChooseCourse(@Param("studentID")String studentID,@Param("Page")Page page);

    public int countNoChooseCourse(String studentID);

    public List<Course> selectStudentChooseCourse(@Param("studentID")String studentID,@Param("Page")Page page);

    public int countStudentChooseCourse(String studentID);

    public List<Course> selectStudentFinishCourse(@Param("studentID")String studentID,@Param("Page")Page page);

    public int countStudentFinishCourse(String studentID);

    public List<Course> selectNoChooseCourseByName(@Param("studentID")String studentID,@Param("courseName")String courseName);

    public int countCourseByTeacherID(String userID);

    public List<Course> selectTeacherCourse(@Param("userID")String userID,@Param("Page")Page page);

    public List<Course> selectTeacherCourseByName(@Param("userID")String userID,@Param("courseName")String courseName);
}
