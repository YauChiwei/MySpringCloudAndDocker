package com.teecon.microservice.consumer.controller;

import com.teecon.microservice.consumer.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MoviewController {

    private static final Logger logger = LoggerFactory.getLogger(MoviewController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    public User findByUserId(@PathVariable Long id){
        return this.restTemplate.getForObject("http://microservice-provider-user/"+id, User.class);
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        logger.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}
