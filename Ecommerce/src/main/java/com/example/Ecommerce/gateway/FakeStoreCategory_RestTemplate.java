package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.controllerDTO.Response.CategoryResponseDTO;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.List;

@Component("fakeStoreCategory_RestTemplate")
public class FakeStoreCategory_RestTemplate implements ICategoryGateway{

    @Autowired
    private Environment environment;

    private final RestTemplateBuilder restTemplateBuilder;
    private FakeStoreCategory_RestTemplate(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    @Override
    public List<CategoryResponseDTO> getAllCategories() throws IOException {
        String url = environment.getProperty("BASE_URL") +"products/category";
        ResponseEntity<FakeStoreCategoryResponse> response=restTemplateBuilder.build().getForEntity(url, FakeStoreCategoryResponse.class);
        if(response.getBody() == null){
            throw new IOException("Response is empty");
        }
        return null;//CategoryMapper.toCategoryDTOList(response.getBody());
    }
}
