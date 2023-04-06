package com.orbedeveloper.datajpa.repository;

import com.orbedeveloper.datajpa.dto.CourseDTO;
import com.orbedeveloper.datajpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<CourseDTO> findByInstructor_Id(Long id);
}
