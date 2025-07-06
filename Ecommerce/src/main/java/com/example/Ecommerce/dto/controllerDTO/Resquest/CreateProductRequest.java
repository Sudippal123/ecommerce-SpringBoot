package com.example.Ecommerce.dto.controllerDTO.Resquest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateProductRequest {
	private String color;
	private String discount;
	private String model;
	private String title;
	private String category;
	private String brand;
}
