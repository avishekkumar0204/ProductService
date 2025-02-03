package com.example.productservice.services;

import com.example.productservice.exceptions.CategoryNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SelfStoreCategoryService implements CategoryService {
    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    public SelfStoreCategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Category getCategoryById(Long id) throws CategoryNotFoundException {
        System.out.println("SelfStoreCategoryService::getCategoryById");
        Optional<Category> categoryOptional = categoryRepository.findCategoryById(id);
        if(categoryOptional.isEmpty()){
            throw new CategoryNotFoundException("Category with id " + id + " not found");
        }
        return categoryOptional.get();
    }

    @Override
    public List<Category> getAllCategory() {
        System.out.println("SelfStoreCategoryService::getAllCategory");
        return categoryRepository.findAll();
    }
}
