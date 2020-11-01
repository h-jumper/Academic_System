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

    @Override
    public List<Course> selectCourseByTeacherID(int teacherID) {
        return courseMapper.selectCourseByTeacherID(teacherID);
    }

    @Override
    public List<Course> selectNoChooseCourse(String studentID, Page page) {
        return courseMapper.selectNoChooseCourse(studentID,page);
    }

    @Override
    public int countNoChooseCourse(String studentID) {
        return courseMapper.countNoChooseCourse(studentID);
    }

    @Override
    public List<Course> selectStudentChooseCourse(String studentID, Page page) {
        return courseMapper.selectStudentChooseCourse(studentID,page);
    }

    @Override
    public int countStudentChooseCourse(String studentID) {
        return courseMapper.countStudentChooseCourse(studentID);
    }

    @Override
    public List<Course> selectStudentFinishCourse(String studentID, Page page) {
        return courseMapper.selectStudentFinishCourse(studentID, page);
    }

    @Override
    public int countStudentFinishCourse(String studentID) {
        return courseMapper.countStudentFinishCourse(studentID);
    }

    @Override
    public List<Course> selectNoChooseCourseByName(String studentID, String courseName) {
        return courseMapper.selectNoChooseCourseByName(studentID, courseName);
    }

    @Override
    public int countCourseByTeacherID(String userID) {
        return courseMapper.countCourseByTeacherID(userID);
    }

    @Override
    public List<Course> selectTeacherCourse(String userID, Page page) {
        return courseMapper.selectTeacherCourse(userID, page);
    }

    @Override
    public List<Course> selectTeacherCourseByName(String userID, String courseName) {
        return courseMapper.selectTeacherCourseByName(userID, courseName);
    }
}
