package com.example.yukmangan.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.yukmangan.api.ApiEndpoint;
import com.example.yukmangan.api.ApiService;
import com.example.yukmangan.model.IndoneisaModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class IndonesiaViewModel extends ViewModel {
    private MutableLiveData<ArrayList<IndoneisaModel>> mutableLiveData=new MutableLiveData<>();
    public void setDataIndo(){
        Retrofit retrofit= ApiService.getRetrofitService();
        ApiEndpoint apiEndpoint=retrofit.create(ApiEndpoint.class);
        Call<List<IndoneisaModel>> call=apiEndpoint.getDataIndo();
        call.enqueue(new Callback<List<IndoneisaModel>>() {
            @Override
            public void onResponse(Call<List<IndoneisaModel>> call, Response<List<IndoneisaModel>> response) {
                mutableLiveData.setValue((ArrayList<IndoneisaModel>)response.body());
            }

            @Override
            public void onFailure(Call<List<IndoneisaModel>> call, Throwable t) {

            }
        });
    }
        public MutableLiveData<ArrayList<IndoneisaModel>> getDataIndo(){
          return mutableLiveData;
        }
}
