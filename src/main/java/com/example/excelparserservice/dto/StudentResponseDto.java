package com.example.excelparserservice.dto;

import lombok.Data;

@Data
public class StudentResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String email;
}
