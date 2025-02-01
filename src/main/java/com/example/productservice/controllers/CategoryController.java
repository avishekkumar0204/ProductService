package com.example.productservice.controllers;

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

    @GetMapping()
    public List<Category> getAllCategory(){
        System.out.println("CategoryController::getAllCategory");
        return categoryService.getAllCategory();
    }

    @GetMapping("/{id}")
    public List<Product> getAllProductByCategoryId(@PathVariable("id") Long id){
        System.out.println("CategoryController::getAllProductByCategoryId");
        return categoryService.getAllProductByCategoryId(id);
    }
}
