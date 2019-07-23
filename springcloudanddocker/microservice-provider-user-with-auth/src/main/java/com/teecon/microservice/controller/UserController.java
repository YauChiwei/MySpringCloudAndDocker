package com.teecon.microservice.controller;

import com.teecon.microservice.dao.UserRepository;
import com.teecon.microservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findByUserId(@PathVariable Long id){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            UserDetails userDetails = (UserDetails)principal;
            Collection<? extends GrantedAuthority> collection = userDetails.getAuthorities();
            for(GrantedAuthority c : collection){
                logger.info("当前用户是：{}, 角色是:{}");
            }
        }else{
            //do other things
        }
        User user = this.userRepository.getOne(id);
        return user;
    }
}
