package com.trip.advisor.controller;

import com.trip.advisor.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("/{cityName}")
    public ResponseEntity<String> generate(@PathVariable("cityName") String cityName) {
        return ResponseEntity.ok(weatherService.getWeather(cityName));
    }
}
