package com.example.controller;

import java.util.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.model.db1.User;
import com.example.model.db2.Product;
import com.example.service.DataService;

import jakarta.validation.Valid;

@RestController
public class DataController {
    private final DataService dataService;

    
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }
    @PostMapping("/users/add")
    public ResponseEntity<?> addUser(@Valid @RequestBody User user) {
    	System.out.println("received mob no  :-" +user.getMobileNo());
if(user.getName()==null || user.getMobileNo()==null) {
	System.out.println("user name and mobile no should not be null");
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("null values not acceptable");
}
int mobSize=user.getMobileNo().length();
if(mobSize!=10) {
	return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("mobile no should be 10 digits"); 
}
else {
	System.out.println("Received user: " + user.getName());
    	return ResponseEntity.ok(dataService.saveUser(user));
    }}
    @DeleteMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id){
    	    	 dataService.deleteUser(id);
  	 
    	 return "user deleted successfully";
    
    }    
    @PostMapping("/products/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    	System.out.println("received product  :- " + product.getName());
    	return ResponseEntity.ok(dataService.saveProduct(product));
    }
    
//    @GetMapping("/users/all")
//    public Page<User> getUsersPaged(@RequestParam int page, @RequestParam int size) {
//        return UserRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
//    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(dataService.getAllUsers());
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(dataService.getAllProducts());
    }
}