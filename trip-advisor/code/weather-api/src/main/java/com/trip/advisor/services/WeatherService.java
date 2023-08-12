package com.trip.advisor.services;

import com.trip.advisor.services.dto.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

@Service
public class WeatherService {

    @Autowired
    RestTemplate restTemplate;

    public String getWeather(String placeName) {

        URI uri = UriComponentsBuilder.fromUriString("http://api.worldweatheronline.com/premium/v1/weather.ashx")
                .queryParam("q", placeName)
                .queryParam("key", "f78a5e635bfa44c9815113626222112")
                .queryParam("format", "json")
                .build().toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.TEXT_PLAIN);

        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<Weather> test = restTemplate.exchange(uri, HttpMethod.GET, request, Weather.class);
        Weather weather = test.getBody();
        return weather.getData().getConditions().get(0).getTemperature();
    }
}
