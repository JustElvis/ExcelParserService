package com.example.excelparserservice.service.impl;

import com.example.excelparserservice.service.TxtWriterService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class TxtWriterServiceImpl implements TxtWriterService {
    @Override
    public void writeToFile(String filePath, String data) {
        File file = new File(filePath);
        try(FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file -> " + filePath, e);
        }
    }
}
