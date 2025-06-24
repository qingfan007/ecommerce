package com.simple.ecommerce.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;

    private static final String API_URL = "https://api.open-meteo.com/v1/forecast?latitude=%.4f&longitude=%.4f&current_weather=true";

    public String getWeather(double latitude, double longitude) {
        String url = String.format(API_URL, latitude, longitude);
        return restTemplate.getForObject(url, String.class);
    }

}
