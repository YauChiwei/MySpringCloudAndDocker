package com.teecon.microservice.consumer.service;

import com.teecon.microservice.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="microservice-provider-user", fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignFallbackClient {

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}
