package com.trip.advisor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
public class RandomService {

    @Autowired
    RestTemplate restTemplate;

    public List<String> generateNumbers(){
        URI uri = URI.create("https://www.random.org/integers/?num=100&min=1&max=6000000&col=1&base=10&format=plain&rnd=new");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.TEXT_PLAIN);
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> test = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
        String numbers =  test.getBody();

        List<String> generatedNumber = Arrays.asList(numbers.split("\n"));
        return  generatedNumber;
    }
}
