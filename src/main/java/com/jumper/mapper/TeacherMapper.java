package com.jumper.mapper;

import com.jumper.pojo.Page;
import com.jumper.pojo.Student;
import com.jumper.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    public List<Teacher> selectAllTeacher();

    public List<Teacher> selectTeacherByPage(Page page);

    public int teacherCount();

    public Teacher selectTeacherByID(int userID);

    public int addTeacher(Teacher teacher);

    public int updateTeacher(Teacher teacher);

    public int deleteTeacher(int userID);

    public List<Teacher> selectTeacherByName(String userName);

    public int countTeacherByName(String userName);

}
