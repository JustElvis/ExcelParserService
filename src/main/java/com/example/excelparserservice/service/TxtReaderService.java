package com.example.excelparserservice.service;

import java.util.List;

public interface TxtReaderService {
    List<String> readFromFile(String filePath);
}
