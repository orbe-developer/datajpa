# datajpa

A Spring Data JPA reference project demonstrating entity relationships, composite keys, and advanced repository query patterns. Built around a college management domain — students, courses, instructors, and contact information.

**Stack:** Java 17 · Spring Boot 3.0.5 · Spring Data JPA · PostgreSQL · Lombok

---

## What it covers

**Entity relationships:**
- `@OneToOne` — Student and ContactInfo (shared primary key via `@MapsId`)
- `@OneToMany` / `@ManyToOne` — Instructor and Course (bidirectional)
- `@ManyToMany` — Student and Course via join entity with extra data (rating)

**Composite keys:**
- `@IdClass` strategy
- `@EmbeddedId` strategy (StudentCourseKey)

**Repository query methods:**
- JPQL queries with `@Query`
- Native SQL queries (including with pagination)
- Derived query methods (find, read, get, exists, count, delete prefixes)
- Named parameters
- Cross-relationship queries (`findByContactInfo_State`)
- Sorting and ordering
- Projection interfaces (`CourseDTO` with computed properties via `@Value`)

---

## Domain model

```
Instructor (1) ──── (N) Course (N) ──── (N) Student
                                              │
                                        ContactInfo (1:1)
```

**StudentCourse** — join entity with `EmbeddedId` (studentId + courseId) and a `rating` field.

---

## Running locally

### Prerequisites
- Java 17+
- PostgreSQL running on `localhost:5432`
- Database `college` created

### Setup

```bash
mvn clean install
mvn spring-boot:run
```

On startup, `data.sql` seeds the database with 10 students, 10 instructors, and 20 courses. The `Runner` bean executes demo queries and prints results to the console.

---

## Project structure

```
datajpa/
└── src/main/java/com/orbedeveloper/datajpa/
    ├── DatajpaApplication.java
    ├── model/
    │   ├── Student.java
    │   ├── Course.java
    │   ├── Instructor.java
    │   ├── ContactInfo.java
    │   └── embedded_id/
    │       ├── StudentCourse.java
    │       └── StudentCourseKey.java
    ├── repository/
    │   ├── StudentRepository.java
    │   └── CourseRepository.java
    ├── dto/
    │   └── CourseDTO.java
    └── utils/
        └── Runner.java
```
