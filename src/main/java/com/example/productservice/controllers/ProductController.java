package com.example.productservice.controllers;


import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
        System.out.println("ProductController::getProductById-> id:::" + id);
        ResponseEntity<Product> responseEntity = null;
        try{
            Product product  = productService.getProductById(id);
            responseEntity = new ResponseEntity<>(
                product,
                HttpStatus.OK
            );
        }catch(Exception e){
            responseEntity = new ResponseEntity<>(
                HttpStatus.NOT_FOUND
            );
        }
        return responseEntity;
    }

    // Example endpoint:: https://localhost:8080/products
    @GetMapping()
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    // Example endpoint:: https://localhost:8080/products/10
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable("id") Long id){
        ResponseEntity<Product> responseEntity = null;
        try{
            Product product  = productService.deleteProductById(id);
            responseEntity = new ResponseEntity<>(
                product,
                HttpStatus.NO_CONTENT
            );
        }catch(Exception e){
            responseEntity = new ResponseEntity<>(
                HttpStatus.NOT_FOUND
            );
        }
        return responseEntity;
    }

    // Example endpoint:: https://localhost:8080/products/10
    @PatchMapping("/{id}")
    public Product updateProductById(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProductById(id, product);
    }

    // Example endpoint:: https://localhost:8080/products/10
    @PutMapping("/{id}")
    public Product replaceProductById(@PathVariable("id") Long id, @RequestBody Product product){
        return productService.updateProductById(id, product);
    }
}
