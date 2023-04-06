package com.orbedeveloper.datajpa.utils;

import com.orbedeveloper.datajpa.repository.CourseRepository;
import com.orbedeveloper.datajpa.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class Runner implements CommandLineRunner {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public Runner(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Save and SaveAll
        /*Student student1 = new Student("John", "Doe", LocalDate.of(1980, 1, 1));
        Student student2 = new Student("John", "Doe", LocalDate.of(1990, 1, 1));

        studentRepository.saveAll(Set.of(student1, student2));*/

        // Using @Query
        /*studentRepository.findByFirstName("Leora").forEach(System.out::println);
        studentRepository.findByFirstNameLike("ri").forEach(System.out::println);*/

        // studentRepository.findByFirstNameNative("Dari").forEach(System.out::println);

        // studentRepository.findByFirstNameLastNameNamed("Leora", "Tutill").forEach(System.out::println);

        // Update
        // studentRepository.updateFirstNameById(6L, "Jennifer");

        // Using Named Methods (Derived Query Methods)
        // studentRepository.findByBirthDateGreaterThan(LocalDate.of(1985, 1, 1)).forEach(System.out::println);
        // studentRepository.readByBirthDateGreaterThan(LocalDate.of(1985, 1, 1)).forEach(System.out::println);
        // studentRepository.getByBirthDateGreaterThan(LocalDate.of(1985, 1, 1)).forEach(System.out::println);
        // studentRepository.queryByBirthDateGreaterThan(LocalDate.of(1985, 1, 1)).forEach(System.out::println);
        // studentRepository.searchByBirthDateGreaterThan(LocalDate.of(1985, 1, 1)).forEach(System.out::println);
        // studentRepository.streamByBirthDateGreaterThan(LocalDate.of(1985, 1, 1)).forEach(System.out::println);

        /*if (studentRepository.existsByFirstName("Leora")) {
            System.out.println("Leora Exists"); // true
        }*/

        // System.out.println("Count: " + studentRepository.count());
        // System.out.println("Count: " + studentRepository.countByFirstName("Leora"));
        // studentRepository.deleteByFirstName("Leora");

        // Multiple Tables
        // studentRepository.findByContactInfo_State("Michigan").forEach(System.out::println);
        // studentRepository.findByContactInfo_StateIgnoreCase("michigan").forEach(System.out::println);
        // studentRepository.findByContactInfo_StateIgnoringCase("michigan").forEach(System.out::println);

        // studentRepository.findByContactInfo_StateIgnoreCaseOrderByFirstNameAscLastNameDesc("michigan").forEach(System.out::println);
        // studentRepository.findByContactInfo_StateIgnoreCaseOrderById("michigan").forEach(System.out::println);
        // studentRepository.findByContactInfo_StateIgnoreCaseOrderByIdDesc("michigan").forEach(System.out::println);

        // studentRepository.findByContactInfo_StateOrContactInfo_State("Michigan", "Ohio").forEach(System.out::println);
        // studentRepository.findByContactInfo_StateOrContactInfo_StateAllIgnoreCase("michigan", "ohio").forEach(System.out::println);
        // studentRepository.findByContactInfo_StateOrContactInfo_StateAllIgnoringCase("michigan", "Ohio").forEach(System.out::println);

        // Sorting
        // studentRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName")).forEach(System.out::println);
       /* Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "birthDate"), new Sort.Order(Sort.Direction.ASC, "firstName"));
        studentRepository.findAll(sort).forEach(System.out::println);*/

        // Pagination
        /*System.out.println("Page 1");
        Pageable pageable = PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC, "birthDate"));
        studentRepository.findAll(pageable).forEach(System.out::println);

        System.out.println("Page 2");
        pageable = PageRequest.of(1, 6, Sort.by(Sort.Direction.DESC, "birthDate"));
        studentRepository.findAll(pageable).forEach(System.out::println);*/

        /*Pageable pageable1 = Pageable.unpaged();
        studentRepository.findAll(pageable1).forEach(System.out::println);*/

        /*Pageable pageable = PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC, "first_name"));
        studentRepository.findByFirstNameNativePaging("Leora", pageable).forEach(System.out::println);*/

        var result = courseRepository.findByInstructor_Id(1L);
       /* for (var course : result) {
            String instructorInfo = "Instructor: " + course.getInstructor().getFirstName() + " " + course.getInstructor().getLastName();
            System.out.println(instructorInfo + " - Course: " + course.getName());
        }*/

        // Course: -> Instructor: -> Number of students
        for (var course : result) {
            System.out.println(course.getName() + " -> Instructor: " + course.getInstructorName() + " -> Students: " + course.getStudentCount());
        }

    }
}
