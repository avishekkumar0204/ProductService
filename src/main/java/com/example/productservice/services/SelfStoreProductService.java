package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class SelfStoreProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfStoreProductService(
            ProductRepository productRepository,
            CategoryRepository categoryRepository
    ){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findProductById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        return productOptional.get();
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public void deleteProductById(Long id) throws ProductNotFoundException {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProductById(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findProductById(id);
        if(productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        Product existingProduct = productOptional.get();
        if(product.getTitle() != null){
            existingProduct.setTitle(product.getTitle());
        }
        if(product.getPrice() != null){
            existingProduct.setPrice(product.getPrice());
        }
        if(product.getCategory() != null){
            Category category = product.getCategory();
            if(category.getId() == null) {
                Category newCategory = categoryRepository.save(category);
                existingProduct.setCategory(newCategory);
            }
        }
        return productRepository.save(existingProduct);
    }

    @Override
    public Product replaceProductById(Long id, Product product)  {
        Optional<Product> productOptional = productRepository.findProductById(id);
        if(productOptional.isEmpty()){
            return addProduct(product);
        }
        Product existingProduct = productOptional.get();
        if(product.getTitle() != null){
            existingProduct.setTitle(product.getTitle());
        }
        if(product.getPrice() != null){
            existingProduct.setPrice(product.getPrice());
        }
        if(product.getCategory() != null){
            Category category = product.getCategory();
            if(category.getId() == null) {
                Category newCategory = categoryRepository.save(category);
                existingProduct.setCategory(newCategory);
            }
        }
        return productRepository.save(existingProduct);
    }

    @Override
    public Product addProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId() == null){
            Category newCategory = categoryRepository.save(category);
            product.setCategory(newCategory);
        }
        return productRepository.save(product);
    }
}
