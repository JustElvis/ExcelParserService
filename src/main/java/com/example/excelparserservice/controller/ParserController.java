package com.example.excelparserservice.controller;

import com.example.excelparserservice.model.Student;
import com.example.excelparserservice.service.ExcelParser;
import com.example.excelparserservice.service.StudentService;
import com.example.excelparserservice.service.SubmitChangesService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ParserController {
    private static final String FILEPATH = "students.xlsx";
    private final ExcelParser excelParser;
    private final SubmitChangesService submitChangesService;
    private final StudentService studentService;

    @GetMapping("/parse")
    @ApiOperation(value = "Upload parsed data from excel file to database and submit changes")
    public String uploadToDatabase() {
        List<Student> studentsFromExcelFile = excelParser.parse(FILEPATH);
        submitChangesService.submit(studentsFromExcelFile);
        studentService.saveAll(studentsFromExcelFile);
        return "Done";
    }
}
