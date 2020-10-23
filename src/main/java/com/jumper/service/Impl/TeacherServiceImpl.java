package com.jumper.service.Impl;

import com.jumper.mapper.CourseMapper;
import com.jumper.mapper.TeacherMapper;
import com.jumper.pojo.Course;
import com.jumper.pojo.Page;
import com.jumper.pojo.Student;
import com.jumper.pojo.Teacher;
import com.jumper.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<Teacher> selectAllTeacher() {
        return teacherMapper.selectAllTeacher();
    }

    @Override
    public List<Teacher> selectTeacherByPage(Page page) {
        return teacherMapper.selectTeacherByPage(page);
    }

    @Override
    public int teacherCount() {
        return teacherMapper.teacherCount();
    }

    @Override
    public Teacher selectTeacherByID(int userID) {
        return teacherMapper.selectTeacherByID(userID);
    }

    @Override
    public boolean addTeacher(Teacher teacher) {
        Teacher teachers = teacherMapper.selectTeacherByID(teacher.getUserID());
        if (teachers == null){
            teacherMapper.addTeacher(teacher);
            return true;
        }else
            return false;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public boolean deleteTeacher(int userID) {
        List<Course> courseList = courseMapper.selectCourseByTeacherID(userID);
        if (!courseList.isEmpty())
            return false;
        else {
            teacherMapper.deleteTeacher(userID);
            return true;
        }
    }

    @Override
    public List<Teacher> selectTeacherByName(String userName) {
        return teacherMapper.selectTeacherByName(userName);
    }

    @Override
    public int countTeacherByName(String userName) {
        return teacherMapper.countTeacherByName(userName);
    }
}
