package com.example.excelparserservice.repository;

import com.example.excelparserservice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentById(Long id);

    Student findStudentByName(String name);

    Student findStudentByLastName(String lastName);
}
