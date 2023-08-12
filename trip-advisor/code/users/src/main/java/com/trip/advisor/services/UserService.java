package com.trip.advisor.services;

import com.trip.advisor.entity.User;
import com.trip.advisor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    RandomService randomService;

    @Autowired
    private UserRepository userRepository;

    public User login(User userRequest) {
        User user = userRepository.findByEmailAndPassword(userRequest.getEmail(), userRequest.getPassword());

        if (user == null)
            throw new RuntimeException("Invalid username and password");

        return user;
    }

    public User create(User userRequest) {
        userRequest.setCreatedAt(new Date());
        userRequest.setUserId(randomService.generateNumbers());
        return userRepository.save(userRequest);
    }

    public List<User> list() {
        return userRepository.findAll();
    }
}
