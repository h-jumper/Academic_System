package com.jumper.service.Impl;

import com.jumper.mapper.TeacherMapper;
import com.jumper.pojo.Teacher;
import com.jumper.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> selectAllTeacher() {
        return teacherMapper.selectAllTeacher();
    }
}
