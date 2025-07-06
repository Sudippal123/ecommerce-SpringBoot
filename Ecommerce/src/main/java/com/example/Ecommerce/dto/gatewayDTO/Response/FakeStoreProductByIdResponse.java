package com.example.Ecommerce.dto.gatewayDTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FakeStoreProductByIdResponse {
    private String status;
    private String message;
    private FakeStoreProductDetail product;
}
