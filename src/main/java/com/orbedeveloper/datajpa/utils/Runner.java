package com.orbedeveloper.datajpa.utils;

import com.orbedeveloper.datajpa.model.Student;
import com.orbedeveloper.datajpa.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class Runner implements CommandLineRunner {
    private final StudentRepository studentRepository;

    public Runner(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Save and SaveAll
        Student student1 = new Student("John", "Doe", LocalDate.of(1980, 1, 1));
        Student student2 = new Student("John", "Doe", LocalDate.of(1990, 1, 1));

        studentRepository.saveAll(Set.of(student1, student2));

    }
}
