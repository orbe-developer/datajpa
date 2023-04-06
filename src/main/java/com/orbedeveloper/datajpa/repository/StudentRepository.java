package com.orbedeveloper.datajpa.repository;

import com.orbedeveloper.datajpa.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // JPQL Queries
    @Query("select s from Student s where s.firstName = ?1")
    List<Student> findByFirstName(String firstName);

    @Query("select s from Student s where s.firstName like %?1%")
    List<Student> findByFirstNameLike(String firstName);


    // Native SQL Queries
    @Query(value = "select * from student where first_name = ?1", nativeQuery = true)
    List<Student> findByFirstNameNative(String firstName);

    // JPA Query Named Parameters
    @Query("select s from Student s where s.firstName = :firstName and s.lastName = :lastName")
    List<Student> findByFirstNameLastNameNamed(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Modifying
    @Query("update Student s set s.firstName = :firstName where s.id = :id")
    void updateFirstNameById(@Param("id") Long id, @Param("firstName") String firstName);

    // Derived Query Methods
    List<Student> findByBirthDateGreaterThan(LocalDate birthdate);

    List<Student> readByBirthDateGreaterThan(LocalDate birthdate);

    List<Student> getByBirthDateGreaterThan(LocalDate birthdate);

    List<Student> queryByBirthDateGreaterThan(LocalDate birthdate);

    List<Student> searchByBirthDateGreaterThan(LocalDate birthdate);

    List<Student> streamByBirthDateGreaterThan(LocalDate birthdate);

    boolean existsByFirstName(String firstName);

    int countByFirstName(String firstName);

    void deleteByFirstName(String firstName);

    void removeByFirstName(String firstName);


    // Multiple Tables
    List<Student> findByContactInfo_State(String state);

    List<Student> findByContactInfo_StateIgnoreCase(String state);

    List<Student> findByContactInfo_StateIgnoringCase(String state);

    List<Student> findByContactInfo_StateIgnoreCaseOrderByFirstNameAscLastNameDesc(String state);

    List<Student> findByContactInfo_StateIgnoreCaseOrderById(String state);

    List<Student> findByContactInfo_StateIgnoreCaseOrderByIdDesc(String state);


    // Students belonging to any of the states passed by parameter
    List<Student> findByContactInfo_StateOrContactInfo_State(String state1, String state2);

    List<Student> findByContactInfo_StateOrContactInfo_StateAllIgnoreCase(String state1, String state2);

    List<Student> findByContactInfo_StateOrContactInfo_StateAllIgnoringCase(String state1, String state2);

    // Native query paging
    @Query(value = "select * from student where first_name = ?1",
            countQuery = "select count(*) from student where first_name = ?1",
            nativeQuery = true)
    Page<Student> findByFirstNameNativePaging(String firstName, Pageable pageable);


}
