package com.example.Ecommerce.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CategoryWithProductsDTO {
    long id;
    String name;
    List<ProductDTO> productDTOList;
}
