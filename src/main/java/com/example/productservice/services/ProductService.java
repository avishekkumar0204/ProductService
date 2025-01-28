package com.example.productservice.services;

import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProduct();
    Product deleteProductById(Long id);
    Product updateProductById(Long id, Product product);
    Product replaceProductById(Long id, Product product);
}
