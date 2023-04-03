/*
package com.orbedeveloper.datajpa.model.id_class;

import com.orbedeveloper.datajpa.model.Course;
import com.orbedeveloper.datajpa.model.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseKey implements Serializable {
    private Student student;
    private Course course;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourseKey that = (StudentCourseKey) o;
        return Objects.equals(student, that.student) && Objects.equals(course, that.course);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }

    @Override
    public String toString() {
        return "StudentCourseKey{" +
                "student=" + student +
                ", course=" + course +
                '}';
    }
}
*/
