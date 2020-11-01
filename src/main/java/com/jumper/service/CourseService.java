package com.jumper.service;

import com.jumper.pojo.Course;
import com.jumper.pojo.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    public List<Course> selectCourseByPage(Page page);

    public int courseCount();

    public Course selectCourseByID(int courseID);

    public boolean addCourse(Course course);

    public int updateCourse(Course course);

    public int deleteCourse(int courseID);

    public List<Course> selectCourseByName(String courseName);

    public int countCourseByName(String courseName);

    public List<Course> selectCourseByTeacherID(int teacherID);

    public List<Course> selectNoChooseCourse(String studentID,Page page);

    public int countNoChooseCourse(String studentID);

    public List<Course> selectStudentChooseCourse(String studentID,Page page);

    public int countStudentChooseCourse(String studentID);

    public List<Course> selectStudentFinishCourse(String studentID,Page page);

    public int countStudentFinishCourse(String studentID);

    public List<Course> selectNoChooseCourseByName(String studentID,String courseName);

    public int countCourseByTeacherID(String userID);

    public List<Course> selectTeacherCourse(String userID,Page page);

    public List<Course> selectTeacherCourseByName(String userID,String courseName);

}
