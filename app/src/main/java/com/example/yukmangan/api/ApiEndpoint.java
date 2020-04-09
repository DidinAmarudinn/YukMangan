package com.example.yukmangan.api;
import com.example.yukmangan.network.api.Api;
import com.example.yukmangan.network.model.IndoneisaModel;
import com.example.yukmangan.network.model.ProvinsiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndpoint {
    @GET(Api.END_POINT_IDN)
    Call<IndoneisaModel> getSummaryIdn();
    @GET(ApiProvinsi.END_POINT_PROVINSI)
    Call<List<ProvinsiModel>> getProvinsi();
}
