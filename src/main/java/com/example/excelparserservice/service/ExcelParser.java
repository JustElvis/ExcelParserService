package com.example.excelparserservice.service;

import com.example.excelparserservice.model.Student;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelParser {
    public List<Student> parse(String fileName) {
        List<Student> students = new ArrayList<>();
        try(InputStream inputStream = new FileInputStream(fileName);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                Student student = new Student();
                student.assignStudent(row);
                students.add(student);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from excel file -> " + fileName, e);
        }
        return students;
    }
}
