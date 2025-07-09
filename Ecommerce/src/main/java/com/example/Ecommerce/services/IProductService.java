package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.dto.controllerDTO.Response.CreateProductResponse;

import com.example.Ecommerce.dto.controllerDTO.Resquest.CreateProductRequest;


import java.io.IOException;
import java.util.List;

public interface IProductService {
    List<ProductDTO> getProductByCategory(String type) ;
    ProductDTO getProductById(Long Id) ;
    CreateProductResponse createProduct(CreateProductRequest product) ;
}
