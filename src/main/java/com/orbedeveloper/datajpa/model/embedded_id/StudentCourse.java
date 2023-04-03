package com.orbedeveloper.datajpa.model.embedded_id;

import com.orbedeveloper.datajpa.model.Course;
import com.orbedeveloper.datajpa.model.Student;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudentCourse {
    @EmbeddedId
    private StudentCourseKey id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @MapsId("studentId")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "course_id")
    @MapsId("courseId")
    private Course course;

    @Column(name = "rating")
    private int rating;

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", rating=" + rating +
                '}';
    }
}
