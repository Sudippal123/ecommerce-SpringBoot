package com.example.Ecommerce.gateway.api;

import com.example.Ecommerce.dto.controllerDTO.Resquest.CreateProductRequest;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreCreateProductResponse;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreProductByIdResponse;
import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreProductsByCategoryResponse;
import retrofit2.Call;
import retrofit2.http.*;

import java.io.IOException;

public interface FakeStoreProductApi {
    @GET("products/category")
    public Call<FakeStoreProductsByCategoryResponse> getProductsByCategory(@Query("type") String type) throws IOException;

    @GET("products/{id}")
    public Call<FakeStoreProductByIdResponse> getProductById(@Path("id") Long id) throws IOException;

    @POST("products")
    public Call<FakeStoreCreateProductResponse> createProduct(@Body CreateProductRequest request) throws IOException;
}
