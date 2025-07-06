package com.example.Ecommerce.configuration;

import com.example.Ecommerce.gateway.api.FakeStoreCategoryApi;
import com.example.Ecommerce.gateway.api.FakeStoreProductApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    @Autowired
    private Environment environment;
    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl(environment.getProperty("BASE_URL"))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @Bean
    public FakeStoreCategoryApi fakeStoreCategoryApi(Retrofit retrofit){
        return retrofit.create(FakeStoreCategoryApi.class);
    }
    @Bean
    public FakeStoreProductApi fakeStoreProductApi(Retrofit retrofit){
        return retrofit.create(FakeStoreProductApi.class);
    }
}
