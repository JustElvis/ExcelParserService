package com.example.excelparserservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.apache.poi.ss.usermodel.DataFormatter;
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
        DataFormatter formatter = new DataFormatter();
        id = (long) row.getCell(0).getNumericCellValue();
        name = row.getCell(1).getStringCellValue();
        lastName = row.getCell(2).getStringCellValue();
        age = (int) row.getCell(3).getNumericCellValue();
        phoneNumber = formatter.formatCellValue(row.getCell(4));
        email = row.getCell(5).getStringCellValue();
    }
}
