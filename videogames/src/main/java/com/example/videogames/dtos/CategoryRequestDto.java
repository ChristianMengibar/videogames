package com.example.videogames.dtos;

import com.example.videogames.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryRequestDto {
    private final String category_name;
    private final Boolean multiplayer;
}