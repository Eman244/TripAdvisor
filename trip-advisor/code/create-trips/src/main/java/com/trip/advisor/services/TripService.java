package com.trip.advisor.services;

import com.trip.advisor.entity.Trip;
import com.trip.advisor.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TripService {


    @Autowired
    private TripRepository tripRepository;

    public Trip create(Trip trip){
        trip.setCreatedAt(new Date());
        trip.setCountryCurrentTime(String.valueOf(new Date()));
        trip.setProposedTrip(0);
        return  tripRepository.save(trip);
    }

    public List<Trip> myTrips(Long userId){
        return  tripRepository.findAllByUserIdAndProposedTrip(userId, 0);
    }

}
