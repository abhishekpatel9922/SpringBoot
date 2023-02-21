package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axis.dto.ApiResponse;
import com.axis.model.Category;
import com.axis.model.Product;
import com.axis.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public ApiResponse list() {
        return categoryService.findAllCategories();
    }

    @PostMapping("/save")
    public ApiResponse save(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable(name = "id") String categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

    @GetMapping("/getBy/{id}")
    public ApiResponse getById(@PathVariable(name = "id") String categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PostMapping("/addProducts")
    public ApiResponse addProducts(@RequestParam(name = "categoryId") String categoryId, @RequestBody List<Product> productList) {
        return categoryService.addProductsInCategory(categoryId, productList);
    }
}