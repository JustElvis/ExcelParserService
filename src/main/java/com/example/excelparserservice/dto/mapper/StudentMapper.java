package com.example.excelparserservice.dto.mapper;

import com.example.excelparserservice.dto.StudentResponseDto;
import com.example.excelparserservice.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public StudentResponseDto mapToDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setLastName(student.getLastName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setPhoneNumber(student.getPhoneNumber());
        studentResponseDto.setEmail(student.getEmail());
        return studentResponseDto;
    }
}
