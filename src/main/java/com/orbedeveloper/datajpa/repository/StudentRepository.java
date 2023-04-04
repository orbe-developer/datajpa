package com.orbedeveloper.datajpa.repository;

import com.orbedeveloper.datajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
