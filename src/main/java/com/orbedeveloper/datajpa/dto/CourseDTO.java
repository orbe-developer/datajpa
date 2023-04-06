package com.orbedeveloper.datajpa.dto;

import com.orbedeveloper.datajpa.model.Instructor;
import org.springframework.beans.factory.annotation.Value;

// projection interface
public interface CourseDTO {
    Instructor getInstructor();

    String getName();

    // open projection (@Value)
    @Value("#{target.instructor.getFirstName()}")
    String getInstructorName();

    @Value("#{target.studentCourses.size()}")
    int getStudentCount();

}
