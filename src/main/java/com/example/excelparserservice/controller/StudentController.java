package com.example.excelparserservice.controller;

import com.example.excelparserservice.dto.StudentResponseDto;
import com.example.excelparserservice.dto.mapper.StudentMapper;
import com.example.excelparserservice.model.Student;
import com.example.excelparserservice.service.ExcelParser;
import com.example.excelparserservice.service.PdfReportService;
import com.example.excelparserservice.service.StudentService;
import com.example.excelparserservice.service.SubmitChangesService;
import com.example.excelparserservice.service.TxtReaderService;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private final ExcelParser excelParser;
    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final SubmitChangesService submitChangesService;
    private final TxtReaderService txtReaderService;
    private final PdfReportService pdfReportService;

    @GetMapping("/save")
    public String save() {
        List<Student> students = excelParser.parse("students.xlsx");
        students.forEach(System.out::println);
        studentService.saveAll(students);
        return "Done";
    }

    @GetMapping("/{id}")
    public StudentResponseDto findById(@PathVariable Long id) {
        return studentMapper.mapToDto(studentService.findById(id));
    }

    @GetMapping("/findbyname")
    public StudentResponseDto findByName(@RequestParam String name) {
        return studentMapper.mapToDto(studentService.findByName(name));
    }

    @GetMapping("/findbylastname")
    public StudentResponseDto findByLastName(@RequestParam String lastName) {
        return studentMapper.mapToDto(studentService.findByLastName(lastName));
    }

    @GetMapping("/refresh")
    public String refreshDatabase() {
        List<Student> studentsFromExcelFile = excelParser.parse("students.xlsx");
        submitChangesService.submit(studentsFromExcelFile);
        studentService.saveAll(studentsFromExcelFile);
        return "Done";
    }

    @GetMapping("/history")
    public List<String> showChangesHistory() {
        return txtReaderService.readFromFile("change_history.txt");
    }

    @GetMapping("/report/pdf")
    public ResponseEntity<Resource> generatePdfReport() {
        try {
            return pdfReportService.generatePdfReport();
        } catch (IOException | DocumentException e) {
            throw new RuntimeException("Can't generate pdf report", e);
        }
    }
}
