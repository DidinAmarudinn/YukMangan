package com.example.yukmangan.network.api;

import com.example.yukmangan.network.model.IndoneisaModel;
import com.example.yukmangan.network.model.donatur.Donatur;
import com.example.yukmangan.network.model.relawan.Relawan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiEndpoint {
    @GET(Api.END_POINT_IDN)
    Call<IndoneisaModel> getSummaryIdn();

    @GET(Api.GET_RELAWAN_BY_ID)
    Call<Relawan> getDataRelawanById(
            @Query("id") String id_relawan
    );

    @GET(Api.GET_DONATUR)
    Call<Donatur> getDataDonatur();
}
