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

    public List<Course> selectCourseByName(@Param("courseName")String courseName,@Param("Page")Page page);

    public int countCourseByName(String courseName);
}
