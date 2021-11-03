package com.example.crudemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {
    //dependency injection // connection our repository with the service

    private final StudentRepository studentRepository;

    //contructor
    @Autowired
    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<Student> getstudent(){

        return  studentRepository.findAll();
//        return List.of(
//                new Student(
//                        1L,"Ibrahim","ibrahim@gmail.com", LocalDate.of(1996, 2,14),25
//                )
//        );
    }
}
