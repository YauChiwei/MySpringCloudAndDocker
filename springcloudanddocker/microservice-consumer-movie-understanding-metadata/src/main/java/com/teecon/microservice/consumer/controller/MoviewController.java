package com.teecon.microservice.consumer.controller;

import com.teecon.microservice.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MoviewController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired


    @GetMapping("/user/{id}")
    public User findByUserId(@PathVariable Long id){
        return this.restTemplate.getForObject("http://localhost:8600/"+id, User.class);
    }
}
