package com.teecon.microservice.controller;

import com.teecon.microservice.dao.UserRepository;
import com.teecon.microservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findByUserId(@PathVariable Long id){
        User user = this.userRepository.getOne(id);
        return user;
    }
}
