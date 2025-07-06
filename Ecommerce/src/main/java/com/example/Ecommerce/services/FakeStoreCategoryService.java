package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.controllerDTO.Response.CategoryDTO;
import com.example.Ecommerce.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService{
    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return this.categoryGateway.getAllCategories();
    }
}
