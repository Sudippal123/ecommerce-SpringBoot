package com.example.Ecommerce.mapper;

import com.example.Ecommerce.dto.controllerDTO.Response.CategoryDTO;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreCategoryResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryMapper {
    public static List<CategoryDTO> toCategoryDTOList(FakeStoreCategoryResponse fakeStoreCategoryResponse){
        return fakeStoreCategoryResponse.getCategories().stream()
                .map(e ->CategoryDTO.builder()
                        .name(e)
                        .build()
                ).toList();
    }
}
