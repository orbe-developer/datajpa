package com.orbedeveloper.datajpa.model;

//import com.orbedeveloper.datajpa.model.id_class.StudentCourse;
import com.orbedeveloper.datajpa.model.embedded_id.StudentCourse;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_generator")
    @SequenceGenerator(name = "course_generator", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Instructor instructor;

    /*@ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();*/

    //IdClass
    /*@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private Set<StudentCourse> studentCourses = new HashSet<>();*/

    // EmbeddedId
    @OneToMany(mappedBy = "course")
    private Set<StudentCourse> studentCourses = new HashSet<>();

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
