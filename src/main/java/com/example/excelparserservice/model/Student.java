package com.example.excelparserservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.apache.poi.ss.usermodel.Row;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String email;

    public void assignStudent(Row row) {
        name = row.getCell(0).toString();
        lastName = row.getCell(1).toString();
        age = (int) row.getCell(2).getNumericCellValue();
        phoneNumber = row.getCell(3).toString();
        email = row.getCell(4).toString();
    }
}
