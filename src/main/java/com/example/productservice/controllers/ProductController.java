package com.example.productservice.controllers;


import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException{
        System.out.println("ProductController::getProductById-> id:::" + id);
        Product product  = productService.getProductById(id);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
            product,
            HttpStatus.OK
        );
        return responseEntity;
    }

    // Example endpoint:: https://localhost:8080/products
    @GetMapping()
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    // Example endpoint:: https://localhost:8080/products/10
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable("id") Long id) throws ProductNotFoundException{
        productService.deleteProductById(id);
        ResponseEntity<Product> responseEntity = new ResponseEntity<>(
            HttpStatus.NO_CONTENT
        );
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

    @PostMapping()
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
}
