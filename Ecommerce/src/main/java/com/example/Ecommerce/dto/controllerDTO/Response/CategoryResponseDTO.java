package com.example.Ecommerce.dto.controllerDTO.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CategoryResponseDTO {
    private long id;
    private String name;
}
