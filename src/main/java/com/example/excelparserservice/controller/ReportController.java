package com.example.excelparserservice.controller;

import com.example.excelparserservice.service.PdfReportService;
import com.example.excelparserservice.service.TxtReaderService;
import com.itextpdf.text.DocumentException;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ReportController {
    private static final String FILEPATH = "change_history.txt";
    private final TxtReaderService txtReaderService;
    private final PdfReportService pdfReportService;

    @GetMapping("/history-changes")
    @ApiOperation(value = "Show history of changes database")
    public List<String> showChangesHistory() {
        return txtReaderService.readFromFile(FILEPATH);
    }

    @GetMapping("/database/pdf")
    @ApiOperation(value = "Generate pdf file from database")
    public ResponseEntity<Resource> generatePdfReport() {
        try {
            return pdfReportService.generatePdfReport();
        } catch (IOException | DocumentException e) {
            throw new RuntimeException("Can't generate pdf report", e);
        }
    }
}
