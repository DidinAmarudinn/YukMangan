package com.example.yukmangan.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.yukmangan.api.ApiEndpoint;
import com.example.yukmangan.api.ApiService;
import com.example.yukmangan.model.ProvinsiModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProvinsiViewModel extends ViewModel {
    private MutableLiveData<ArrayList<ProvinsiModel>> mutableLiveData=new MutableLiveData<>();
    public void setProvinsiData(){
        Retrofit retrofit= ApiService.getRetrofitService();
        ApiEndpoint apiEndpoint=retrofit.create(ApiEndpoint.class);
        Call<List<ProvinsiModel>> call=apiEndpoint.getProvinsi();
        call.enqueue(new Callback<List<ProvinsiModel>>() {
            @Override
            public void onResponse(Call<List<ProvinsiModel>> call, Response<List<ProvinsiModel>> response) {
                mutableLiveData.setValue((ArrayList<ProvinsiModel>)response.body());
            }

            @Override
            public void onFailure(Call<List<ProvinsiModel>> call, Throwable t) {

            }
        });
    }
    public MutableLiveData<ArrayList<ProvinsiModel>> getProvinsiData()
    {
        return mutableLiveData;
    }
}
