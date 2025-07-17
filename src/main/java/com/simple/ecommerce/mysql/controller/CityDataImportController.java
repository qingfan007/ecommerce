package com.simple.ecommerce.mysql.controller;

import com.simple.ecommerce.mysql.service.CityDataImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/data-import")
public class CityDataImportController {

    @Autowired
    private CityDataImportService cityDataImportService;

    @PostMapping("/cities")
    public ResponseEntity<String> importCities(@RequestParam("file") MultipartFile file) {
        try {
            cityDataImportService.importCitiesFromXml(file.getInputStream());
            return ResponseEntity.ok("Cities imported successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Import failed: " + e.getMessage());
        }
    }
}
