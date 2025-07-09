package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.controllerDTO.Response.CategoryResponseDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {
    List<CategoryResponseDTO> getAllCategories() throws IOException;
}
