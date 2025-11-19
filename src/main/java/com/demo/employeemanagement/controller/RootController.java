package com.demo.employeemanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class RootController {

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> root() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to Employee Management API!");
        response.put("status", "UP");
        response.put("endpoints", Map.of(
            "employees", "/api/employees",
            "health", "/api/health"
        ));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api")
    public ResponseEntity<Map<String, Object>> api() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Employee Management API");
        response.put("version", "1.0.0");
        response.put("endpoints", Map.of(
            "employees", "/api/employees",
            "health", "/api/health"
        ));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        return ResponseEntity.ok(response);
    }
}

