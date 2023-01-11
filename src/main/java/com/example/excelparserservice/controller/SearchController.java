package com.example.excelparserservice.controller;

import com.example.excelparserservice.dto.StudentResponseDto;
import com.example.excelparserservice.dto.mapper.StudentMapper;
import com.example.excelparserservice.service.StudentService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class SearchController {
    private final StudentMapper studentMapper;
    private final StudentService studentService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Find student by id")
    public StudentResponseDto findById(@PathVariable Long id) {
        return studentMapper.mapToDto(studentService.findById(id));
    }

    @GetMapping("/by-name")
    @ApiOperation(value = "Find student by name")
    public StudentResponseDto findByName(@RequestParam String name) {
        return studentMapper.mapToDto(studentService.findByName(name));
    }

    @GetMapping("/by-lastname")
    @ApiOperation(value = "Find student by lastname")
    public StudentResponseDto findByLastName(@RequestParam String lastName) {
        return studentMapper.mapToDto(studentService.findByLastName(lastName));
    }
}
