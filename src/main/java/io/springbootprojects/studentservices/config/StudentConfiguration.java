package io.springbootprojects.studentservices.config;

import io.springbootprojects.studentservices.model.Student;
import io.springbootprojects.studentservices.model.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student Bob = new Student("Bob", LocalDate.of(2000, 1, 20), "bob123@gmail.com");
            Student Alice = new Student("Alice", LocalDate.of(2000, 12, 20), "alice1990@gmail.com");
            studentRepository.saveAll(List.of(Alice, Bob));
        };
    }
}
