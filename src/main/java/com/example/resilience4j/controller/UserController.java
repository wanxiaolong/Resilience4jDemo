package com.example.resilience4j.controller;

import com.example.resilience4j.entity.User;
import com.example.resilience4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") int id) {
        return service.findById(id);
    }
}
