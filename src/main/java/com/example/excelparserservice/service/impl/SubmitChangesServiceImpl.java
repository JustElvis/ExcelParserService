package com.example.excelparserservice.service.impl;

import com.example.excelparserservice.model.Student;
import com.example.excelparserservice.service.StudentService;
import com.example.excelparserservice.service.SubmitChangesService;
import com.example.excelparserservice.service.TxtWriterService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubmitChangesServiceImpl implements SubmitChangesService {
    private static final String FILEPATH = "change_history.txt";
    private final TxtWriterService txtWriterService;
    private final StudentService studentService;

    @Override
    public void submit(List<Student> dataFromExcel) {
        List<Student> changedStudents = dataFromExcel.stream()
                .filter(student -> !student.equals(studentService.findById(student.getId())))
                .toList();
        if (!changedStudents.isEmpty()) {
            changedStudents.forEach(student -> txtWriterService
                    .writeToFile(FILEPATH, "old -> "
                    + studentService.findById(student.getId()) + " --- new -> "
                    + student + " " + LocalDateTime.now() + System.lineSeparator()));
        }
    }
}
