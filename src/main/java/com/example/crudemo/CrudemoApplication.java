package com.example.crudemo;

import com.example.crudemo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController //make the class restfull
public class CrudemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudemoApplication.class, args);
	}
	@GetMapping("/")
	public String hello(){
		return "Hello world";
	}
	@GetMapping("/ibrahim")
	public  List<String>  ibrahim(){
		return List.of("Ibrahim","Kiprotich");
	}
	@GetMapping("/student")
	public List<Student> mystudent(){
		return List.of(
				new Student(
						1,"Ibrahim","ibrahim@gmail.com", LocalDate.of(1996, 2,14),25
				)
		);
	}

}
