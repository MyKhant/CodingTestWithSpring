package com.example.codeteststudentregistration;

import com.example.codeteststudentregistration.dao.StudentDao;
import com.example.codeteststudentregistration.entity.Student;
import com.example.codeteststudentregistration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
public class CodeTestStudentRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeTestStudentRegistrationApplication.class, args);
        System.out.println("Student Registration");

    }


}
