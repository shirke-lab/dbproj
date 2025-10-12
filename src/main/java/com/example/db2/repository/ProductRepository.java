package com.example.db2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.db2.Product;


	public interface ProductRepository extends JpaRepository<Product, Long> {
	}
