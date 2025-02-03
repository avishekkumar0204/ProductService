package com.example.productservice.repositories;

import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductById(Long id);
    List<Product> findAll();
    void deleteById(Long id);
    Product save(Product product);
    List<Product> findProductByCategoryId(Long id);
}


/*
    The ProductRepository interface extends JpaRepository,
    which is a Spring Data interface that provides CRUD operations for the Product entity.
    The JpaRepository interface takes two parameters: the entity type (Product) and the type of the entity's primary key (Long).
    By extending JpaRepository, the ProductRepository interface inherits methods for saving, updating, deleting,
    and querying Product entities from the database.
 */