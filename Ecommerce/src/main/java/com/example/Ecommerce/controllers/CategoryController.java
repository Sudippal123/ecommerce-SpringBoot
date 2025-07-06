package com.example.Ecommerce.controllers;


import com.example.Ecommerce.dto.controllerDTO.Response.CategoryDTO;
import com.example.Ecommerce.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws IOException {
        List<CategoryDTO> response = this.categoryService.getAllCategories();
        return ResponseEntity.ok(response);
    }
}
