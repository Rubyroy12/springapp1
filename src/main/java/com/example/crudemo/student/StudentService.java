package com.example.crudemo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getstudent(){
        return List.of(
                new Student(
                        1L,"Ibrahim","ibrahim@gmail.com", LocalDate.of(1996, 2,14),25
                )
        );
    }
}
