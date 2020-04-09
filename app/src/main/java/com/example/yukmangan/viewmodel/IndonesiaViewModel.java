package com.example.yukmangan.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.yukmangan.network.api.ApiEndpoint;
import com.example.yukmangan.network.api.ApiService;
import com.example.yukmangan.network.model.IndoneisaModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IndonesiaViewModel extends ViewModel {
    private MutableLiveData<IndoneisaModel> mutableLiveData=new MutableLiveData<>();
    public void setCountryData(){
        Retrofit retrofit= ApiService.getRetrofitService();
        ApiEndpoint apiEndPoint=retrofit.create(ApiEndpoint.class);
        Call<IndoneisaModel> call=apiEndPoint.getSummaryIdn();
        call.enqueue(new Callback<IndoneisaModel>() {
            @Override
            public void onResponse(Call<IndoneisaModel> call, Response<IndoneisaModel> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<IndoneisaModel> call, Throwable t) {

            }
        });
    }
    public LiveData<IndoneisaModel> getCountryData(){
        return mutableLiveData;
    }
}

