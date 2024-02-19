package com.example.videogames.dtos;

import com.example.videogames.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ProductRequestDto {
    private String name;
    private String platform;
    private Date launch;
    private Integer rating;
    private String description;
    private Double price;
}
