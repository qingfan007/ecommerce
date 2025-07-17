package com.simple.ecommerce.util;

import com.simple.ecommerce.mysql.model.CitiesWrapper;
import com.simple.ecommerce.mysql.model.CityXmlDTO;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import java.io.InputStream;
import java.util.List;

public class XmlParserUtil {

    public static List<CityXmlDTO> parseCitiesXml(InputStream inputStream) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(CitiesWrapper.class);
        CitiesWrapper wrapper = (CitiesWrapper) context.createUnmarshaller().unmarshal(inputStream);
        return wrapper.getCities();
    }

}
