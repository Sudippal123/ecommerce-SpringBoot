package com.example.Ecommerce.mapper;

import com.example.Ecommerce.dto.controllerDTO.Response.CreateProductResponse;
import com.example.Ecommerce.dto.controllerDTO.Response.ProductDTO;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreCreateProductResponse;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreProductByIdResponse;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreProductsByCategoryResponse;

import java.util.List;

public class ProductMapper {

    public static CreateProductResponse toCreateProductResponse(FakeStoreCreateProductResponse fakeStoreCreateProductResponse){
        return CreateProductResponse.builder()
                .product(fakeStoreCreateProductResponse.getProduct())
                .message(fakeStoreCreateProductResponse.getStatus())
                .status(fakeStoreCreateProductResponse.getMessage()).build();
    }

    public static ProductDTO toProductDTO(FakeStoreProductByIdResponse response){
        return ProductDTO.builder()
                .brand(response.getProduct().getBrand())
                .model(response.getProduct().getModel())
                .price(response.getProduct().getPrice())
                .title(response.getProduct().getTitle())
                .build();
    }

    public static List<ProductDTO> toProductDTOList(FakeStoreProductsByCategoryResponse response){
        return response.getProducts().stream().map(e ->
                ProductDTO.builder()
                        .title(e.getTitle())
                        .price(e.getPrice())
                        .model(e.getModel())
                        .brand(e.getBrand())
                        .build()
                ).toList();
    }
}
