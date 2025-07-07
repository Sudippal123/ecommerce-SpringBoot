package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.controllerDTO.Response.CreateProductResponse;
import com.example.Ecommerce.dto.controllerDTO.Response.ProductDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CreateProductRequest;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreCreateProductResponse;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreProductByIdResponse;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreProductsByCategoryResponse;
import com.example.Ecommerce.gateway.api.FakeStoreProductApi;
import com.example.Ecommerce.mapper.ProductMapper;
import org.springframework.stereotype.Component;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreProductGateway implements IProductGateway {
    private final FakeStoreProductApi fakeStoreProductApi;

    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String type) throws IOException {
        FakeStoreProductsByCategoryResponse response = fakeStoreProductApi.getProductsByCategory(type).execute().body();
        return ProductMapper.toProductDTOList(response);
    }

    @Override
    public ProductDTO getProductById(Long Id) throws IOException {
        FakeStoreProductByIdResponse response = fakeStoreProductApi.getProductById(Id).execute().body();
        return ProductMapper.toProductDTO(response);
    }

    @Override
    public CreateProductResponse createProduct(CreateProductRequest productRequest) throws IOException {

        Response<FakeStoreCreateProductResponse> response = fakeStoreProductApi.createProduct(productRequest).execute();
        if(response.isSuccessful() ){
            return ProductMapper.toCreateProductResponse(response.body());
        }
        else {
            System.out.println("API Error: " + response.errorBody().string());
            return null;
        }

    }
}
