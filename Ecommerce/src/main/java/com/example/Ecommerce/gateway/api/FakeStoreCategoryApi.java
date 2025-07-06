package com.example.Ecommerce.gateway.api;

import com.example.Ecommerce.dto.gatewayDTO.Response.FakeStoreCategoryResponse;
import retrofit2.Call;
import retrofit2.http.GET;


public interface FakeStoreCategoryApi {
    @GET("products/category")
    Call<FakeStoreCategoryResponse> getAllFakeStoreCategories();
}
