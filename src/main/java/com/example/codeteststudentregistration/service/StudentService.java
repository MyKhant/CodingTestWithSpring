package com.example.codeteststudentregistration.service;


import com.example.codeteststudentregistration.dao.StudentDao;
import com.example.codeteststudentregistration.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;

    public List<Student> getAllStudents() {
        ArrayList<Student> studentList = new ArrayList<>();
        studentDao.findAll().forEach(student -> studentList.add(student));
        return studentList;
    }

    public Student getStudentById(Integer id) {
        return studentDao.findById(id).get();
    }

    public boolean saveOrUpdateStudent(Student student) {
        Student updatedObj = studentDao.save(student);

        if (getStudentById(updatedObj.getId()) != null) {
            return true;
        }

        return false;
    }

    public boolean deleteStudent(Integer id) {
        studentDao.deleteById(id);

        if (studentDao.findById(id).isEmpty()) {
            return true;
        }

        return false;
    }
}
