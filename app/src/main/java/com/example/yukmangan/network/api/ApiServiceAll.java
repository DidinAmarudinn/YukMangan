package com.example.yukmangan.network.api;

import androidx.core.os.BuildCompat;

import com.intuit.sdp.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceAll {
    public static Retrofit getRetrofitService() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = (new OkHttpClient.Builder()).connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(interceptor);

        OkHttpClient client = builder.build();

        return new Retrofit.Builder()
                .baseUrl(Api.BASE_URL1)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
