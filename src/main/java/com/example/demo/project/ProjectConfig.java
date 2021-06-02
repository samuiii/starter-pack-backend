package com.example.demo.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class ProjectConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProjectRepository repository){
        return args -> {
            Project oop = new Project( "OOP", "none", 5, LocalDate.of(2020, FEBRUARY, 5));
            Project compro = new Project( "COMPRO", "none", 4, LocalDate.of(2019, FEBRUARY, 5));
            repository.saveAll(List.of(oop,compro));
        };
    }
}
