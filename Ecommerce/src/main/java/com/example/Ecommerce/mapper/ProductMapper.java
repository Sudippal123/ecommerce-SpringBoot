package com.example.Ecommerce.mapper;

import com.example.Ecommerce.dto.ProductWithCategoryDTO;
import com.example.Ecommerce.dto.controllerDTO.Response.CategoryResponseDTO;
import com.example.Ecommerce.dto.controllerDTO.Response.CreateProductResponse;
import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CreateProductRequest;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreCreateProductResponse;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreProductsByCategoryResponse;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.entity.Product;

import java.util.List;

public class ProductMapper {

    public static CreateProductResponse toCreateProductResponse(FakeStoreCreateProductResponse fakeStoreCreateProductResponse){
        return CreateProductResponse.builder()
                .product(fakeStoreCreateProductResponse.getProduct())
                .message(fakeStoreCreateProductResponse.getStatus())
                .status(fakeStoreCreateProductResponse.getMessage()).build();
    }
    public static ProductDTO ToProductDTO(Product productResult){
        return ProductDTO.builder()
                .id(productResult.getId())
                .title(productResult.getTitle())
                .discount(productResult.getDiscount())
                .brand(productResult.getBrand())
                .popular(productResult.isPopular())
                .category_id(productResult.getCategory().getId())
                .color(productResult.getColor())
                .model(productResult.getModel())
                .image(productResult.getImage())
                .popular(productResult.isPopular())
                .price(productResult.getPrice())
                .description(productResult.getDescription())
                .build();
    }
    public static Product ToEntity(CreateProductRequest productRequest,Category category){
        return Product.builder()
                .title(productRequest.getTitle())
                .discount(productRequest.getDiscount())
                .brand(productRequest.getBrand())
                .popular(productRequest.isPopular())
                .category(category)
                .color(productRequest.getColor())
                .model(productRequest.getModel())
                .image(productRequest.getImage())
                .popular(productRequest.isPopular())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
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
    public static ProductWithCategoryDTO toProductWithCategoryDTO(Product product){
        return ProductWithCategoryDTO.builder()
                .id(product.getId())
                .title(product.getTitle())
                .discount(product.getDiscount())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .category(CategoryResponseDTO.builder().id(product.getCategory().getId()).name(product.getCategory().getName()).build())
                .color(product.getColor())
                .model(product.getModel())
                .image(product.getImage())
                .popular(product.isPopular())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}
