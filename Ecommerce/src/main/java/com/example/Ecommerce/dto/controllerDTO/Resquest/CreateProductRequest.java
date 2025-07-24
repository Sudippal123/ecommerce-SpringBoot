package com.example.Ecommerce.dto.controllerDTO.Resquest;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateProductRequest {
	private String title ;
	private String image ;
	private double price ;
	private String description ;
	private String brand ;
	private String model ;
	private String color ;
	private long category_id ;
	private boolean popular ;
	private int discount ;
}
