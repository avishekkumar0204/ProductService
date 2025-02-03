package com.example.productservice.services;

import com.example.productservice.exceptions.CategoryNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long id) throws CategoryNotFoundException;
    List<Category> getAllCategory();
}
