package com.example.Ecommerce.dto.gatewayDTO.Response;

import com.example.Ecommerce.dto.ProductDTO;
import lombok.Getter;

@Getter
public class FakeStoreCreateProductResponse{
	private ProductDTO product;
	private String message;
	private String status;
}
