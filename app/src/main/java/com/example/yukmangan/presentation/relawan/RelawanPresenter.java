package com.example.yukmangan.presentation.relawan;

import android.util.Log;

import com.example.yukmangan.network.api.ApiEndpoint;
import com.example.yukmangan.network.api.ApiServiceAll;
import com.example.yukmangan.network.model.relawan.Relawan;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RelawanPresenter {

    public RelawanView view;

    public final void getDataRelawanById(String id_relawan){
        ApiServiceAll.getRetrofitService()
                .create(ApiEndpoint.class)
                .getDataRelawanById(id_relawan)
                .enqueue(new Callback<Relawan>() {
            @Override
            public void onResponse(Call<Relawan> call, Response<Relawan> response) {
                Log.e("ERROR",response.body().getData().toString());
                Log.e("ERROR",response.body().toString());
                if (response.body() != null){
                    RelawanPresenter.this.view.getDataRelawanById(response.body());
                }else {
                    Log.e("ERROR_PRESENTER","respon null");
                }
            }

            @Override
            public void onFailure(Call<Relawan> call, Throwable t) {
                RelawanPresenter.this.view.onFailure(t);

            }
        });
    }


}
