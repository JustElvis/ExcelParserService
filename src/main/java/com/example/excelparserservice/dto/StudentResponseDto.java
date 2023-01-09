package com.example.excelparserservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String email;
}
