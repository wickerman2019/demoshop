package com.example.demoshop.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demoshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
