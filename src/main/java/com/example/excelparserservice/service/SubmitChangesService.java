package com.example.excelparserservice.service;

import com.example.excelparserservice.model.Student;
import java.util.List;

public interface SubmitChangesService {
    void submit(List<Student> dataFromExcel);
}
