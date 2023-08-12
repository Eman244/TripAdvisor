package com.trip.advisor.repository;

import com.trip.advisor.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> findAllByUserIdAndProposedTrip(Long userId, Integer isProposedTrip);

    List<Trip> findAllByProposedTrip(Integer isProposedTrip);
}
