package com.example.Ecommerce.controllers;

import com.example.Ecommerce.dto.ProductWithCategoryDTO;
import com.example.Ecommerce.dto.controllerDTO.Response.CreateProductResponse;
import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CreateProductRequest;
import com.example.Ecommerce.services.IProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/category")
    public List<ProductDTO> getProductByCategory(@RequestParam("type") String type) {
        return this.productService.getProductByCategory(type);
    }
    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable("id") Long id) {
        return this.productService.getProductById(id);
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest product) {
        CreateProductResponse response = productService.createProduct(product);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}/category")
    public ResponseEntity<ProductWithCategoryDTO> getProductWithCategory(@PathVariable("id") Long id){
        ProductWithCategoryDTO response = productService.getProductWithCategory(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllExpensiveProduct(@RequestParam("minPrice") double minPrice){
        List<ProductDTO> productDTOList = productService.getAllExpensiveProducts(minPrice);
        return ResponseEntity.ok(productDTOList);
    }

}
