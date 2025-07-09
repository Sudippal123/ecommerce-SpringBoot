package com.example.Ecommerce.controllers;


import com.example.Ecommerce.dto.controllerDTO.Response.CategoryResponseDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CategoryRequestDTO;
import com.example.Ecommerce.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CategoryController {

    private final ICategoryService categoryService;
    CategoryController(ICategoryService categoryService){
        this.categoryService = categoryService;
    }
    @GetMapping("categories")
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        List<CategoryResponseDTO> response = this.categoryService.getAllCategories();
        return ResponseEntity.ok(response);
    }
    @PostMapping("category")
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO category){
        CategoryResponseDTO response = categoryService.createCategory(category);
        return ResponseEntity.ok(response);
    }
}
