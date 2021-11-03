package com.example.crudemo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    //dependency injection // connection our repository with the service

    private final StudentRepository studentRepository; //interface class

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


    public void addStudent(Student student) {
//        System.out.println(student);
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw  new IllegalStateException("Email is taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
       boolean exist= studentRepository.existsById(studentId);

       if (!exist){
           throw  new IllegalStateException("Student with  ID " + studentId + "  not exist");
       }
       studentRepository.deleteById(studentId);

    }
    @Transactional//to make the entity go to manage state
    public void updateStudent(Long studentId,String name,String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->
                new IllegalStateException("Student with id " + studentId + " doest not exit")
                );
        if (name!=null && name.length() > 0 && !Objects.equals(student.getEmail(),name)){
            student.setName(name);

        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {

            Optional<Student> studentOptional= studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {

                throw  new IllegalStateException("Email is taken");
            }
            student.setEmail(email);
        }

    }
}
