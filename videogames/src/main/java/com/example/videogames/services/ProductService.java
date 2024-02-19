package com.example.videogames.services;

import com.example.videogames.models.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {

    Product findById(Long id);

    Product findByUuid(UUID uuid);

    List<Product> findProductsByName(String name);

    List<Product> findProductsByToBuy(boolean toBuy);

    List<Product> findProductsByToCheck(boolean toCheck);

    void deleteById(Long id);

    Product update(Long id, Product product);

    Product setToBuy(Long id, Boolean toBuy, LocalDateTime toBuyTimestamp);

    Product setToCheck(Long id, Boolean toCheck, LocalDateTime toCheckTimestamp);

    Product setStock(Long id, Double stock, LocalDateTime stockTimestamp);

    List<Product> findAll();

    List<Product> findProductsByCategoryId(Long categoryId);

    Product patch(Long id, Product product);

    List<Product> findByStockLessThanEqual(Double lowStock);

    List<Product> saveAll(List<Product> products);
}
