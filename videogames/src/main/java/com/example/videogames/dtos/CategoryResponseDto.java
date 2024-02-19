package com.example.videogames.dtos;

import com.example.videogames.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryResponseDto {
    private final String category_name;
    private final Boolean multiplayer;
    private List<Product> products;
}