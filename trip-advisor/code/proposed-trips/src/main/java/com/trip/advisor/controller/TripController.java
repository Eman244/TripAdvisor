package com.trip.advisor.controller;

import com.trip.advisor.entity.Trip;
import com.trip.advisor.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody Trip trip){
        return ResponseEntity.ok(tripService.create(trip));
    }


    @GetMapping("/proposed")
    public ResponseEntity proposed()
    {
        return ResponseEntity.ok(tripService.listProposedTrips());
    }
}
