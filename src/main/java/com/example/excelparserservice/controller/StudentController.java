package com.example.excelparserservice.controller;

import com.example.excelparserservice.dto.StudentResponseDto;
import com.example.excelparserservice.dto.mapper.StudentMapper;
import com.example.excelparserservice.model.Student;
import com.example.excelparserservice.service.ExcelParser;
import com.example.excelparserservice.service.StudentService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final ExcelParser excelParser;
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @GetMapping("/save")
    public String save() {
        List<Student> students = excelParser.parse("students.xlsx");
        students.forEach(System.out::println);
        studentService.saveAll(students);
        return "Done";
    }

    @GetMapping("/{id}")
    public StudentResponseDto findById(@PathVariable Long id) {
        return studentMapper.mapToDto(studentService.findById(id));
    }

    @GetMapping("/findByName")
    public StudentResponseDto findByName(@RequestParam String name) {
        return studentMapper.mapToDto(studentService.findByName(name));
    }

    @GetMapping("/findByLastName")
    public StudentResponseDto findByLastName(@RequestParam String lastName) {
        return studentMapper.mapToDto(studentService.findByLastName(lastName));
    }
}
