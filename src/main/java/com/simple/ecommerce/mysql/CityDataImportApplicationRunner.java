package com.simple.ecommerce.mysql;

import com.simple.ecommerce.mysql.service.CityDataImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * just for test
 */
@Component
@RequiredArgsConstructor
public class CityDataImportApplicationRunner implements CommandLineRunner {

    @Autowired
    private CityDataImportService cityDataImportService;

    @Override
    public void run(String... args) throws Exception {

        InputStream xmlInput = this.getClass().getResourceAsStream("/cities.xml");
        cityDataImportService.importCitiesFromXml(xmlInput);
        System.out.println("City Data Import Successful (XML -> DB)");

    }
}
