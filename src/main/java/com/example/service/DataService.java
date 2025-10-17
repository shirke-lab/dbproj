package com.example.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.example.db1.repository.*;
import com.example.db2.repository.ProductRepository;
import com.example.model.db2.Product;
import com.example.model.db1.User;


@Service
public class DataService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

  User user=new User();//we cant autowire model entities. so, we can create object of that class and then we can use it.
  
    
    public DataService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
public void deleteUser(Long uid) {
	
	userRepository.findById(uid).orElseThrow(()->new RuntimeException ("user id not Found"));
		 userRepository.deleteById(uid);
		 System.out.println("user is deleted  :-" +user.getName());
	}
	

    
    public User saveUser(User user) {
     String mobno= user.getMobileNo(); 
//     System.out.println(mobno);
     String mobil=String.valueOf(mobno);
//     System.out.println(mobil);
    	if( mobil.length()!=10) {
    		//System.out.println("number should be 10 digits");
    		throw new IllegalArgumentException("mobile no. should be 10 digits");
    //		return null;  this line is not usable after throwing exception
    	}

    	Optional<?> mob=  userRepository.findBymobileNo(mobil);	
    		if(mob.isEmpty()) 
    		{
    			System.out.println("we are adding this user");
    		}
    		if(mob.isPresent()) 
    		{
    			//System.out.println("mobile no is already exist");
    			throw new IllegalStateException("mobile no. is already exist");
    			//return null;
    		}
    	// String message=mob.isPresent() ? "mobile no. is already Exist" : "we  are adding this user";
//    	System.out.println(message);

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
