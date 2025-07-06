package com.example.Ecommerce.dto.controllerDTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProductDTO {
    private String title;
    private double price;
    private String brand;
    private String model;
}
