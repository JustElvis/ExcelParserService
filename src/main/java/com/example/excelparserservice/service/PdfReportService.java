package com.example.excelparserservice.service;

import com.example.excelparserservice.model.Student;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PdfReportService {
    private static final String TITLE = "Students info";
    private final StudentService studentService;

    public ResponseEntity<Resource> generatePdfReport() throws IOException, DocumentException {
        Document document = new Document(PageSize.A4, 25, 25, 25, 25);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);
        document.open();
        Paragraph title = new Paragraph(TITLE,
                FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD,
                        new BaseColor(0, 255, 255)));
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        PdfPTable table = new PdfPTable(new float[]{1, 3, 3, 1, 3, 6});
        table.setSpacingBefore(25);
        table.setSpacingAfter(25);
        PdfPCell c1 = new PdfPCell(new Phrase("Id"));
        table.addCell(c1);
        PdfPCell c2 = new PdfPCell(new Phrase("Name"));
        table.addCell(c2);
        PdfPCell c3 = new PdfPCell(new Phrase("LastName"));
        table.addCell(c3);
        PdfPCell c4 = new PdfPCell(new Phrase("Age"));
        table.addCell(c4);
        PdfPCell c5 = new PdfPCell(new Phrase("Phone Number"));
        table.addCell(c5);
        PdfPCell c6 = new PdfPCell(new Phrase("Email"));
        table.addCell(c6);
        List<Student> students = studentService.findAll();
        for (Student student : students) {
            table.addCell(String.valueOf(student.getId()));
            table.addCell(student.getName());
            table.addCell(student.getLastName());
            table.addCell(String.valueOf(student.getAge()));
            table.addCell(student.getPhoneNumber());
            table.addCell(student.getEmail());
        }
        document.add(table);
        document.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=StudentPdfReport.pdf");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        return new ResponseEntity<>(new InputStreamResource(inputStream), headers, HttpStatus.OK);
    }
}
