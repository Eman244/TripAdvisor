package com.trip.advisor.repository;

import com.trip.advisor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByEmailAndPassword(String email, String password);
}
