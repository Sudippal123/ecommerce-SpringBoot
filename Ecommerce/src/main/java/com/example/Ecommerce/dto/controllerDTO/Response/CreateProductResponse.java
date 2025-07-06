package com.example.Ecommerce.dto.controllerDTO.Response;

import com.example.Ecommerce.dto.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateProductResponse{
	private Product product;
	private String message;
	private String status;
}
