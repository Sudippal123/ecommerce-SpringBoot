package com.example.Ecommerce.dto;

import com.example.Ecommerce.dto.controllerDTO.Response.CategoryResponseDTO;
import lombok.Builder;

@Builder
public class ProductWithCategoryDTO {
    private Long id ;
    private String title ;
    private String image ;
    private double price ;
    private String description ;
    private String brand ;
    private String model ;
    private String color ;
    private Long category_id ;
    private boolean popular ;
    private int discount ;
    private CategoryResponseDTO category;
}
