package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.controllerDTO.Response.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {
    List<CategoryDTO> getAllCategories() throws IOException;
}
