package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}