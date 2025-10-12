package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import com.example.db1.repository.*;
import com.example.db2.repository.ProductRepository;
import com.example.model.db1.*;
import com.example.model.db2.Product;

@Service
public class DataService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public DataService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
