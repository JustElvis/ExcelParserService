package com.example.excelparserservice.service.impl;

import com.example.excelparserservice.model.Student;
import com.example.excelparserservice.repository.StudentRepository;
import com.example.excelparserservice.service.StudentService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public void saveAll(List<Student> students) {
        studentRepository.saveAll(students);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public Student findByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Override
    public Student findByLastName(String lastName) {
        return studentRepository.findStudentByLastName(lastName);
    }
}
