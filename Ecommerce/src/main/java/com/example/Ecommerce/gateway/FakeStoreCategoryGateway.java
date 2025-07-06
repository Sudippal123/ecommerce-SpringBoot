package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.controllerDTO.Response.CategoryDTO;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreCategoryResponse;
import com.example.Ecommerce.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{
    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponse response = this.fakeStoreCategoryApi.getAllFakeStoreCategories().execute().body();

        return response.getCategories().stream()
                .map( category -> CategoryDTO.builder()
                        .name(category)
                        .build()).toList();
    }
}
