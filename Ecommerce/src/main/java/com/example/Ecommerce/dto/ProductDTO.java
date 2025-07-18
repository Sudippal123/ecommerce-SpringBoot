package com.example.Ecommerce.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
	private Long id ;
	private String title ;
	private String image ;
	private int price ;
	private String description ;
	private String brand ;
	private String model ;
	private String color ;
	private Long category_id ;
	private boolean popular ;
	private int discount ;
}
