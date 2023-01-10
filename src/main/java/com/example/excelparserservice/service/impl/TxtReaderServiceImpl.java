package com.example.excelparserservice.service.impl;

import com.example.excelparserservice.service.TxtReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TxtReaderServiceImpl implements TxtReaderService {
    @Override
    public List<String> readFromFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
    }
}
