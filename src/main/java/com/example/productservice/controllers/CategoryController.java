package com.example.productservice.controllers;

import com.example.productservice.exceptions.CategoryNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable("id") Long id) throws CategoryNotFoundException {
        System.out.println("CategoryController::getCategoryById");
        return categoryService.getCategoryById(id);
    }

    @GetMapping()
    public List<Category> getAllCategory(){
        System.out.println("CategoryController::getAllCategory");
        return categoryService.getAllCategory();
    }
}
