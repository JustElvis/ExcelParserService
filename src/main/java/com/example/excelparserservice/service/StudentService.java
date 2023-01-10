package com.example.excelparserservice.service;

import com.example.excelparserservice.model.Student;
import java.util.List;

public interface StudentService {
    void saveAll(List<Student> students);
    Student findById(Long id);
    Student findByName(String name);
    Student findByLastName(String lastName);
    List<Student> findAll();
}
