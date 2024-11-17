package com.example.studentmanagement.service;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockData {
    @Autowired
    private StudentRepository studentRepository;

    @PostConstruct
    public void initData(){
        createStudents().forEach(student -> {
            studentRepository.save(student);
        });
    }

    private List<Student> createStudents(){
        List<Student> students = new ArrayList<Student>();
        Student student1 = new Student();
        student1.setFirstName("Ivan");
        student1.setLastName("Ivanov");
        student1.setMiddleName("Ivanovich");
        student1.setGroup("F14");
        student1.setAverageScore(4.9);

        students.add(student1);
        return students;
    }

}
