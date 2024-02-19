package com.example.videogames.services;

import com.example.videogames.models.Category;
import com.example.videogames.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    Category findByUuid(UUID uuid);

    List<Category> findCategoriesByDescription(String description);

    void deleteById(Long id);

    Category update(Long id, Category category);

    List<Product> getProductsByCategoryId(Long id);

    Integer countProductsChecked(Long categoryId);
}
