package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.controllerDTO.Response.CreateProductResponse;
import com.example.Ecommerce.dto.controllerDTO.Response.ProductDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CreateProductRequest;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    List<ProductDTO> getProductByCategory(String type) throws IOException;
    ProductDTO getProductById(Long Id) throws IOException;
    CreateProductResponse addProduct(CreateProductRequest product) throws IOException;
}
