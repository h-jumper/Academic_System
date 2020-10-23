package com.jumper.service.Impl;

import com.jumper.mapper.StudentMapper;
import com.jumper.pojo.Course;
import com.jumper.pojo.Page;
import com.jumper.pojo.Student;
import com.jumper.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> selectStudentByPage(Page page) {
        return studentMapper.selectStudentByPage(page);
    }

    @Override
    public int studentCount() {
        return studentMapper.studentCount();
    }

    @Override
    public Student selectStudentByID(int userID) {
        return studentMapper.selectStudentByID(userID);
    }

    @Override
    public boolean addStudent(Student student) {
        Student students = studentMapper.selectStudentByID(student.getUserID());
        if (students == null){
            studentMapper.addStudent(student);
            return true;
        }else
            return false;
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int deleteStudent(int userID) {
        return studentMapper.deleteStudent(userID);
    }

    @Override
    public List<Student> selectStudentByName(String studentName) {
        return studentMapper.selectStudentByName(studentName);
    }

    @Override
    public int countStudentByName(String studentName) {
        return studentMapper.countStudentByName(studentName);
    }
}
