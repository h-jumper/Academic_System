package com.jumper.service.Impl;

import com.jumper.mapper.CourseMapper;
import com.jumper.pojo.Course;
import com.jumper.pojo.Page;
import com.jumper.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Course> selectCourseByPage(Page page) {
        return courseMapper.selectCourseByPage(page);
    }

    @Override
    public int courseCount() {
        return courseMapper.courseCount();
    }

    @Override
    public Course selectCourseByID(int courseID) {
        return courseMapper.selectCourseByID(courseID);
    }

    @Override
    public boolean addCourse(Course course) {
        Course courses = courseMapper.selectCourseByID(course.getCourseID());
        if (courses == null){
            courseMapper.addCourse(course);
            return true;
        }else
            return false;
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public int deleteCourse(int courseID) {
        return courseMapper.deleteCourse(courseID);
    }

    @Override
    public List<Course> selectCourseByName(String courseName) {
        return courseMapper.selectCourseByName(courseName);
    }

    @Override
    public int countCourseByName(String courseName) {
        return courseMapper.countCourseByName(courseName);
    }
}
