package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.controllerDTO.Response.CategoryResponseDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CategoryRequestDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponseDTO>  getAllCategories() ;
    CategoryResponseDTO createCategory(CategoryRequestDTO request);
    CategoryResponseDTO getCategoryById(Long id);
}
