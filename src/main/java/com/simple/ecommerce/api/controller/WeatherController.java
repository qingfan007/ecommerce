package com.simple.ecommerce.api.controller;

import com.simple.ecommerce.api.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /**
     * /api/weather?latitude=31.2304&longitude=121.4737
     */
    @GetMapping
    public ResponseEntity<String> getWeather(@RequestParam double latitude,
                                             @RequestParam double longitude) {

        return ResponseEntity.ok().body(weatherService.getWeather(latitude, longitude));
    }

}
