package com.example.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.model.db1.User;
import com.example.model.db2.Product;
import com.example.service.DataService;

import jakarta.validation.Valid;

@RestController
public class DataController {
    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/api/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/users/add")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
    	System.out.println("Received user: " + user.getName());
        return ResponseEntity.ok(dataService.saveUser(user));
    }
    @PostMapping("/products/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    	System.out.println("received product  :- " + product.getName());
    	
    	        return ResponseEntity.ok(dataService.saveProduct(product));
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(dataService.getAllUsers());
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(dataService.getAllProducts());
    }
}