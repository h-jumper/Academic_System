package com.jumper.service;

import com.jumper.pojo.Page;
import com.jumper.pojo.Student;

import java.util.List;

public interface StudentService {
    public List<Student> selectStudentByPage(Page page);

    public int studentCount();

    public Student selectStudentByID(int userID);

    public boolean addStudent(Student student);

    public int updateStudent(Student student);

    public int deleteStudent(int Student);

    public List<Student> selectStudentByName(String studentName);

    public int countStudentByName(String studentName);
}
