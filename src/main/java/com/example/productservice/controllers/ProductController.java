package com.example.productservice.controllers;


import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    // Example endpoint:: https://localhost:8080/products/10
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        System.out.println("ProductController::getProductById-> id:::" + id);
        return productService.getProductById(id);
    }

    // Example endpoint:: https://localhost:8080/products
    @GetMapping()
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
}
