package com.example.Ecommerce.dto.controllerDTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProductDTO {
    private String title ;
    private String image ;
    private double price ;
    private String description ;
    private String brand ;
    private String model ;
    private String color ;
    private String category ;
    private boolean popular ;
    private int discount ;
}
