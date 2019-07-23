package com.teecon.microservice.consumer.controller;

import com.teecon.microservice.consumer.pojo.User;
import com.teecon.microservice.consumer.service.UserFeignClient;
import com.teecon.microservice.consumer.service.UserFeignFallbackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private UserFeignFallbackClient userFeignFallbackClient;

    @GetMapping("/user/{id}")
    public User findByUserId(@PathVariable Long id){
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/user/reason/{id}")
    public User findByUserIdFallbackReason(@PathVariable Long id){
        return this.userFeignFallbackClient.findById(id);
    }
}
