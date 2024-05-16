package com.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;

import org.springframework.validation.annotation.Validated;

import com.tasks.service.UserService;

@RestController
@Validated
@RequestMapping("/user")
public class HealthCheckController implements HealthIndicator {

    @Autowired
    private UserService userService;

    @Value("${service.status}")
    private String serviceStatus;

    @Override
    public Health health() {
        String status = userService.isServiceUp() ? "UP" : "DOWN";
        if (status.equals(serviceStatus)) {
            return Health.up().withDetail("message", "Service is up and running!").build();
        } else {
            return Health.down().withDetail("message", "Service is down").build();
        }
    }

    @GetMapping("/health")
    public String healthCheck() {
        return health().getStatus().equals(Status.UP) ? "Service is up and running!" : "Service is down";
    }
}
