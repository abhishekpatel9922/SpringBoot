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
import com.axis.dto.ProductDTO;
import com.axis.model.Product;
import com.axis.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public ApiResponse list() {
        return productService.findAllProducts();
    }

    @PostMapping("/save")
    public ApiResponse save(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/update")
    public ApiResponse update(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable(name = "id") String productId) {
        return productService.deleteProduct(productId);
    }

    @GetMapping("/getBy/{id}")
    public ApiResponse getById(@PathVariable(name = "id") String productId) {
        return productService.getProductById(productId);
    }

    @PostMapping("/purchase")
    public ApiResponse purchase(@RequestParam(name = "userId") Integer userId, @RequestBody List<ProductDTO> productList) {
        return productService.purchaseProducts(userId, productList);
    }
}