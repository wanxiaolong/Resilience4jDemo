package com.example.resilience4j.service;

import com.example.resilience4j.entity.User;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private boolean isDBAvailable = true;

    @CircuitBreaker(name = "DemoCircuitBreaker")
    public User findById(int id) {
        if (isDBAvailable) {
            return new User(id, "小龙" + id, id % 20 + 18);
        } else {
            throw new RuntimeException("Database is not available");
        }
    }

    //暴露给AdminController用于动态模拟DB的可用性
    public void setDBAvailable(boolean isDBAvailable) {
        this.isDBAvailable = isDBAvailable;
    }
}
