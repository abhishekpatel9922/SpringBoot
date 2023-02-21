package com.axis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}