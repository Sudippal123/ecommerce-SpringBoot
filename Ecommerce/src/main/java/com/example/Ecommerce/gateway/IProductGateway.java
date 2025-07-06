package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.controllerDTO.Response.CreateProductResponse;
import com.example.Ecommerce.dto.controllerDTO.Response.ProductDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CreateProductRequest;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {
    List<ProductDTO> getProductsByCategory(String type) throws IOException;
    ProductDTO getProductById(Long Id) throws IOException;
    CreateProductResponse createProduct(CreateProductRequest productRequest) throws IOException;
}
