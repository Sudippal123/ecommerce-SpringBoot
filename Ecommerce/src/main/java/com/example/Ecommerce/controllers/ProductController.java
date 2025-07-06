package com.example.Ecommerce.controllers;

import com.example.Ecommerce.dto.controllerDTO.Response.CreateProductResponse;
import com.example.Ecommerce.dto.controllerDTO.Response.ProductDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CreateProductRequest;
import com.example.Ecommerce.services.IProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/category")
    public List<ProductDTO> getProductByCategory(@RequestParam("type") String type) throws IOException {
        return this.productService.getProductByCategory(type);
    }
    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable("id") Long id) throws IOException {
        return this.productService.getProductById(id);
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateProductResponse> addProduct(@RequestBody CreateProductRequest product) throws IOException{

        CreateProductResponse response = productService.addProduct(product);
        return ResponseEntity.ok(response);
    }
}
