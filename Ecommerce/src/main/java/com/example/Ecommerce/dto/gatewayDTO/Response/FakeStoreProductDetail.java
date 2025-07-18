package com.example.Ecommerce.dto.gatewayDTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FakeStoreProductDetail {
    private Long id;
    private String title;
    private String image;
    private int price;
    private String description;
    private String brand;
    private String model;
    private String color;
    private String category;
    private double discount;
    private boolean onSale;
}
