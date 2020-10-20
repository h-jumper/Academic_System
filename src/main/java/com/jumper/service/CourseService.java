package com.jumper.service;

import com.jumper.pojo.Course;
import com.jumper.pojo.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {
    public List<Course> selectCourseByPage(Page page);

    public int courseCount();

    public Course selectCourseByID(int courseID);

    public boolean addCourse(Course course);

    public int updateCourse(Course course);

    public int deleteCourse(int courseID);

    public List<Course> selectCourseByName(String courseName,Page page);

    public int countCourseByName(String courseName);
}
