package com.example.videogames.repositories;

import com.example.videogames.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductByUuid(UUID uuid);
    List<Product> findProductsByNameContainsIgnoreCase(String name);
    List<Product> findProductsByCategoryId(Long categoryId);
}
