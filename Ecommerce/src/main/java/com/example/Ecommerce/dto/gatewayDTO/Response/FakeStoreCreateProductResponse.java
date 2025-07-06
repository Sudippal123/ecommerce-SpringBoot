package com.example.Ecommerce.dto.gatewayDTO.Response;

import com.example.Ecommerce.dto.Product;
import lombok.Getter;

@Getter
public class FakeStoreCreateProductResponse{
	private Product product;
	private String message;
	private String status;
}
