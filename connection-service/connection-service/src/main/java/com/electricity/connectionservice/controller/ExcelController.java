package com.electricity.connectionservice.controller;

import com.electricity.connectionservice.service.ExcelService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/excel")
public class ExcelController {
    @Autowired
    private ResourceLoader resourceLoader;
    private final ExcelService excelService;
    String defaultFilePath = "static/excel/electricity_board_case_study.csv";

    @Autowired
    public ExcelController(ExcelService excelService) {
        this.excelService = excelService;
    }

    @PostMapping("/import")
    public void importExcelData(@RequestParam(required = false) String filePath) throws IOException {
        // Using the provided filePath if not null, otherwise use the defaultFilePath
        String actualFilePath = (filePath != null) ? filePath : defaultFilePath;
        Resource resource = resourceLoader.getResource("classpath:" + actualFilePath);

        try (InputStream inputStream = resource.getInputStream()) {
            excelService.importData(inputStream);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}

