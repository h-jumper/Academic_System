package com.jumper.service.Impl;

import com.jumper.mapper.SelectedCourseMapper;
import com.jumper.pojo.SelectedCourse;
import com.jumper.pojo.StudentMark;
import com.jumper.service.SelectedCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectedCourseServiceImpl implements SelectedCourseService {

    @Autowired
    SelectedCourseMapper selectedCourseMapper;

    @Override
    public int insertSelectedCourse(SelectedCourse selectedCourse) {
        return selectedCourseMapper.insertSelectedCourse(selectedCourse);
    }

    @Override
    public int deleteSelectedCourse(SelectedCourse selectedCourse) {
        return selectedCourseMapper.deleteSelectedCourse(selectedCourse);
    }

    @Override
    public List<StudentMark> selectStudentMarkByCourseID(int courseID) {
        return selectedCourseMapper.selectStudentMarkByCourseID(courseID);
    }

    @Override
    public StudentMark selectStudentMark(int userID, int courseID) {
        return selectedCourseMapper.selectStudentMark(userID, courseID);
    }

    @Override
    public int updateMark(SelectedCourse selectedCourse) {
        return selectedCourseMapper.updateMark(selectedCourse);
    }

    @Override
    public int countStudentChoose(int userID) {
        return selectedCourseMapper.countStudentChoose(userID);
    }
}
