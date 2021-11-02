package com.example.crudemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;


import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication

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


}
