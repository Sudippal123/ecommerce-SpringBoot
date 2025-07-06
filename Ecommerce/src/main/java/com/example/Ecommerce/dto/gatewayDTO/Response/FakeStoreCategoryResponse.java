package com.example.Ecommerce.dto.gatewayDTO.Response;

import lombok.Getter;

import java.util.List;

@Getter
public class FakeStoreCategoryResponse {
    private String status;
    private String message;
    private List<String> categories;
}
