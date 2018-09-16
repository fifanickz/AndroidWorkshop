package com.arit.demo.localstoage.service;

import com.arit.demo.localstoage.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface ProductService {
    String BASEURL = "http://10.0.2.2:3000/";
    Retrofit retrofit = new  Retrofit.Builder()
                                    .baseUrl(BASEURL)
                                    .addConverterFactory(GsonConverterFactory
                                                        .create())
                                                        .build();
    @GET("products")
    Call<List<Product>> getAll();
}
