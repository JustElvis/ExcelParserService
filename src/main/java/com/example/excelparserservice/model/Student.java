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
    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String email;

    public void assignStudent(Row row) {
        id = (long) row.getCell(0).getNumericCellValue();
        name = row.getCell(1).getStringCellValue();
        lastName = row.getCell(2).getStringCellValue();
        age = (int) row.getCell(3).getNumericCellValue();
        phoneNumber = row.getCell(4).getStringCellValue();
        email = row.getCell(5).getStringCellValue();
    }
}
