package com.example.excelparserservice.service.impl;

import com.example.excelparserservice.model.Student;
import com.example.excelparserservice.service.StudentService;
import com.example.excelparserservice.service.SubmitChangesService;
import com.example.excelparserservice.service.TxtWriterService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubmitChangesServiceImpl implements SubmitChangesService {
    private final TxtWriterService txtWriterService;
    private final StudentService studentService;

    @Override
    public void submit(List<Student> dataFromExcel) {
        List<Student> changedStudents = dataFromExcel.stream()
                .filter(student -> !student.equals(studentService.findById(student.getId())))
                .toList();
        if (!changedStudents.isEmpty()) {
            changedStudents.forEach(student -> txtWriterService.writeToFile("change_history.txt", "old -> "
                    + studentService.findById(student.getId()) + " --- new -> " + student + System.lineSeparator()));
        }
    }
}
