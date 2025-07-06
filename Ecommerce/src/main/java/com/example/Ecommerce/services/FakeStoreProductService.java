package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.controllerDTO.Response.CreateProductResponse;
import com.example.Ecommerce.dto.controllerDTO.Response.ProductDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CreateProductRequest;
import com.example.Ecommerce.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{
    private final IProductGateway productGateway;

    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<ProductDTO> getProductByCategory(String type) throws IOException {
        return this.productGateway.getProductsByCategory(type);
    }

    @Override
    public ProductDTO getProductById(Long Id) throws IOException {
        return this.productGateway.getProductById(Id);
    }

    @Override
    public CreateProductResponse addProduct(CreateProductRequest product) throws IOException {
        return this.productGateway.createProduct(product);
        //return null;
    }
}
