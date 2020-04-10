package com.example.yukmangan.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.yukmangan.api.ApiService;
import com.example.yukmangan.network.api.ApiEndpoint;
import com.example.yukmangan.network.api.ApiServiceAll;
import com.example.yukmangan.network.model.BeritaModel;
import com.example.yukmangan.network.model.ProvinsiModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class BeritaViewModel extends ViewModel {
    private MutableLiveData<ArrayList<BeritaModel>> mutableLiveData=new MutableLiveData<>();
    public void setDataBerita(){
        Retrofit retrofit= ApiServiceAll.getRetrofitService();
        ApiEndpoint apiEndpoint=retrofit.create(ApiEndpoint.class);
        Call<List<BeritaModel>> call=apiEndpoint.getListBerita();
        call.enqueue(new Callback<List<BeritaModel>>() {
            @Override
            public void onResponse(Call<List<BeritaModel>> call, Response<List<BeritaModel>> response) {
                mutableLiveData.setValue((ArrayList<BeritaModel>)response.body());
            }
            @Override
            public void onFailure(Call<List<BeritaModel>> call, Throwable t) {

            }
        });
    }
    public MutableLiveData<ArrayList<BeritaModel>> getBeritaData()
    {
        return mutableLiveData;
    }
}
