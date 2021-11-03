package com.example.crudemo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student ibrahim=new Student(

                    "Ibrahim",
                    "ibrahim@gmail.com",
                    LocalDate.of(1996, 2,14)

            );
            Student mark = new Student(
                    "JOhnmark",
                    "mark@gmail.com",
                    LocalDate.of(1998,3,7)
            );
            repository.saveAll(
                    List.of(ibrahim,mark)
            );

        };

    }

}
