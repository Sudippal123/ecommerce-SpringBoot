package com.example.Ecommerce.dto.gatewayDTO.Request;

import lombok.Builder;

@Builder
public class FakeStoreCreateProductRequest{
	private String color;
	private int discount;
	private String model;
	private String title;
	private String category;
	private String brand;
}
