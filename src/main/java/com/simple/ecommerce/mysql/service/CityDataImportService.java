package com.simple.ecommerce.mysql.service;

import com.simple.ecommerce.mysql.entity.City;
import com.simple.ecommerce.mysql.model.CityXmlDTO;
import com.simple.ecommerce.mysql.repository.CityRepository;
import com.simple.ecommerce.util.XmlParserUtil;
import jakarta.transaction.Transactional;
import jakarta.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityDataImportService {

    @Autowired
    private CityRepository cityRepository;

    @Transactional
    public void importCitiesFromXml(InputStream xmlInputStream) throws JAXBException {
        List<CityXmlDTO> dtos = XmlParserUtil.parseCitiesXml(xmlInputStream);

        List<City> cities = dtos.stream()
                .filter(dto -> StringUtils.hasText(dto.getName()) && StringUtils.hasText(dto.getCountry()))
                .map(dto -> {
                    City c = new City();
                    c.setName(dto.getName().trim());
                    c.setCountry(dto.getCountry().trim());
                    c.setZipcode(dto.getZipcode() != null ? dto.getZipcode().trim() : "000000");
                    return c;
                }).toList();

        cityRepository.saveAll(cities);
    }


}
