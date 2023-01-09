package com.example.excelparserservice.service;

import com.example.excelparserservice.model.Student;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class ExcelParser {
    public List<Student> parse(String fileName) {
        List<Student> students = new ArrayList<>();
        InputStream inputStream = null;
        XSSFWorkbook workbook = null;
        try {
            inputStream = new FileInputStream(fileName);
            workbook = new XSSFWorkbook((inputStream));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from excel file -> " + fileName, e);
        }
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Student student = new Student();
            Row row = iterator.next();
            student.assignStudent(row);
            students.add(student);
        }
        return students;
    }
}
