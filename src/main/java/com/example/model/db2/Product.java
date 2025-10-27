package com.example.model.db2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull @NotBlank
    private Double price;

    // Getters and Setters
    public String getName() {
    	return name;
    }

    

	public Double getPrice() {
		return price;
	}

	
	
    
}
