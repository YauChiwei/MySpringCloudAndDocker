package com.teecon.microservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ProviderUserApplication {
    public static void main(String[] args){
        SpringApplication.run(ProviderUserApplication.class, args);
    }

    @Value("${server.port}")
    String port;
    @RequestMapping("/user")
    public String home(@RequestParam String name) {
        return "hi "+name+",this is microservice-provider-user-instance1";
    }
}
