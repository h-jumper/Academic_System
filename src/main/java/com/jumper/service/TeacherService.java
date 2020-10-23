package com.jumper.service;

import com.jumper.pojo.Page;
import com.jumper.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    public List<Teacher> selectAllTeacher();

    public List<Teacher> selectTeacherByPage(Page page);

    public int teacherCount();

    public Teacher selectTeacherByID(int userID);

    public boolean addTeacher(Teacher teacher);

    public int updateTeacher(Teacher teacher);

    public boolean deleteTeacher(int userID);

    public List<Teacher> selectTeacherByName(String userName);

    public int countTeacherByName(String userName);
}
