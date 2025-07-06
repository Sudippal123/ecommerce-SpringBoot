package com.example.Ecommerce.gateway;

import com.example.Ecommerce.dto.controllerDTO.Response.CreateProductResponse;
import com.example.Ecommerce.dto.controllerDTO.Response.ProductDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CreateProductRequest;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreCreateProductResponse;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreProductByIdResponse;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreProductsByCategoryResponse;
import com.example.Ecommerce.gateway.api.FakeStoreProductApi;
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
        return response.getProducts().stream()
                .map( product -> ProductDTO.builder()
                        .price(product.getPrice())
                        .title(product.getTitle())
                        .brand(product.getBrand())
                        .model(product.getModel()).build()
                ).toList();
    }

    @Override
    public ProductDTO getProductById(Long Id) throws IOException {
        FakeStoreProductByIdResponse response = fakeStoreProductApi.getProductById(Id).execute().body();

        return ProductDTO.builder()
                .title(response.getProduct().getTitle())
                .price(response.getProduct().getPrice())
                .brand(response.getProduct().getBrand())
                .model(response.getProduct().getModel()).build();
    }

    @Override
    public CreateProductResponse createProduct(CreateProductRequest productRequest) throws IOException {

        Response<FakeStoreCreateProductResponse> response = fakeStoreProductApi.createProduct(productRequest).execute();

        if(response.isSuccessful() ){
            return CreateProductResponse.builder()
                    .product(response.body().getProduct())
                    .status(response.body().getStatus())
                    .message(response.body().getMessage()).build();
        }
        else {
            System.out.println("API Error: " + response.errorBody().string());
            return null;
        }

    }
}
