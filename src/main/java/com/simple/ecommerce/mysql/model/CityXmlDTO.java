package com.simple.ecommerce.mysql.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class CityXmlDTO {
    private String name;
    private String country;
    private String zipcode;
}
