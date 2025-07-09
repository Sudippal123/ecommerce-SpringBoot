package com.example.Ecommerce.mapper;

import com.example.Ecommerce.dto.controllerDTO.Response.CategoryResponseDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CategoryRequestDTO;
import com.example.Ecommerce.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public static CategoryResponseDTO toCategoryDTO(Category category){
        return CategoryResponseDTO.builder().id(category.getId()).name(category.getName()).build();
    }
    public static Category toCategoryEntity(CategoryRequestDTO requestDTO){
        return Category.builder().name(requestDTO.getName()).build();
    }
    public static Category toCategoryEntity(CategoryResponseDTO requestDTO){
        return Category.builder().name(requestDTO.getName()).build();
    }

}
