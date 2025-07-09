package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.controllerDTO.Response.CategoryResponseDTO;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreCategoryResponse;
import com.example.Ecommerce.gateway.api.FakeStoreCategoryApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("fakeStoreCategoryGateway")
public class FakeStoreCategoryGateway implements ICategoryGateway{
    private final FakeStoreCategoryApi fakeStoreCategoryApi;

    public FakeStoreCategoryGateway(FakeStoreCategoryApi fakeStoreCategoryApi) {
        this.fakeStoreCategoryApi = fakeStoreCategoryApi;
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponse response = this.fakeStoreCategoryApi.getAllFakeStoreCategories().execute().body();
        if(response == null){
           throw new IOException("Response is empty!!");
        }
        return null;
    }
}
