package com.example.yukmangan.api;

import com.example.yukmangan.network.api.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    public static Retrofit getRetrofitService() {
        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static Retrofit getRetrofitService1() {
        return new Retrofit.Builder()
                .baseUrl(ApiProvinsi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
