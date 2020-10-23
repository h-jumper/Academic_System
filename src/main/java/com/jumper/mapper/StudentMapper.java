package com.jumper.mapper;
import com.jumper.pojo.Page;
import com.jumper.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    public List<Student> selectStudentByPage(Page page);

    public int studentCount();

    public Student selectStudentByID(int userID);

    public int addStudent(Student student);

    public int updateStudent(Student student);

    public int deleteStudent(int userID);

    public List<Student> selectStudentByName(String studentName);

    public int countStudentByName(String studentName);
}

