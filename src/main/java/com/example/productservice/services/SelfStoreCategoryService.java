package com.example.productservice.services;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfStoreCategoryService implements CategoryService {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public SelfStoreCategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Category getCategoryById(Long id) {
        System.out.println("SelfStoreCategoryService::getCategoryById");
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public List<Category> getAllCategory() {
        System.out.println("SelfStoreCategoryService::getAllCategory");
        return categoryRepository.findAll();
    }
}
