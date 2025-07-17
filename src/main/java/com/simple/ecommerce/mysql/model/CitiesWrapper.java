package com.simple.ecommerce.mysql.model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement(name = "cities")
@XmlAccessorType(XmlAccessType.FIELD)
public class CitiesWrapper {

    @XmlElement(name = "city")
    private List<CityXmlDTO> cities;
}
