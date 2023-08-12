package com.trip.advisor.controller;

import com.trip.advisor.services.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generate")
@CrossOrigin(origins = "*")
public class RandomController {

    @Autowired
    RandomService randomService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity generate(){
        return ResponseEntity.ok(randomService.generateNumbers());
    }
}
