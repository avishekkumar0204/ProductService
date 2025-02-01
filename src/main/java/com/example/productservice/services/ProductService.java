package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProduct();
    void deleteProductById(Long id) throws ProductNotFoundException;
    Product updateProductById(Long id, Product product) throws ProductNotFoundException;
    Product replaceProductById(Long id, Product product);
    Product addProduct(Product product);
}
