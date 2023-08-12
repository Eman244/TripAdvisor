package com.trip.advisor.controller;

import com.trip.advisor.entity.Trip;
import com.trip.advisor.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
public class TripController {

    @Autowired
    TripService tripService;

    @PostMapping("/create") // POST MAPPING MAPPED TO CREATE REQUEST ONLY IN SPECIFIC PROJECT
    public ResponseEntity create(@RequestBody Trip trip) {
        return ResponseEntity.ok(tripService.create(trip));
    }

    @GetMapping("/{userId}") // GET MAPPING ONLY MAPPED TO THE USER ID
    public ResponseEntity userTrips(@PathVariable Long userId) {
        return ResponseEntity.ok(tripService.myTrips(userId));
    }

}
