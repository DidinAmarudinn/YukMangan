package com.example.yukmangan.api;

import com.example.yukmangan.model.ProvinsiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET(Api.END_POINT_PROVINSI)
    Call<List<ProvinsiModel>> getProvinsi();
}
