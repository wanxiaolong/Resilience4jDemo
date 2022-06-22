package com.example.resilience4j.controller;

import com.example.resilience4j.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private UserService service;

    @PostMapping("/db/enable")
    public String enableDB() {
        service.setDBAvailable(true);
        return "enabled";
    }

    @PostMapping("/db/disable")
    public String disableDB() {
        service.setDBAvailable(false);
        return "disabled";
    }
}
