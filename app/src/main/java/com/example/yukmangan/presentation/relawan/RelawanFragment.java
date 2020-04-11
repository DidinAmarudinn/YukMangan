package com.example.yukmangan.presentation.relawan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yukmangan.R;
import com.example.yukmangan.network.api.ApiEndpoint;
import com.example.yukmangan.network.api.ApiServiceAll;
import com.example.yukmangan.network.model.donatur.Datum;
import com.example.yukmangan.network.model.donatur.Donatur;
import com.example.yukmangan.network.model.relawan.Relawan;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RelawanFragment extends Fragment {

    private TextView nama, alamat;
    private RecyclerView recyclerViewDonatur;
    private DonaturRelawanAdapter donaturRelawanAdapter;
    private List<Datum> item;

    public RelawanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_relawan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nama = view.findViewById(R.id.tv_name_relawan_dashboard);
        alamat =view.findViewById(R.id.tv_alamat_relawan_dashboard);
        recyclerViewDonatur = view.findViewById(R.id.rv_donasi_warga);

        ApiServiceAll.getRetrofitService()
                .create(ApiEndpoint.class)
                .getDataRelawanById("52")
                .enqueue(new Callback<Relawan>() {
                    @Override
                    public void onResponse(Call<Relawan> call, Response<Relawan> response) {
                        nama.setText(response.body().getData().get(0).getNamaLengkap());
                        alamat.setText(response.body().getData().get(0).getAlamat());
                    }

                    @Override
                    public void onFailure(Call<Relawan> call, Throwable t) {


                    }
                });

       /* ApiServiceAll.getRetrofitService().create(ApiEndpoint.class)
                .getDataDonatur().enqueue(new Callback<Donatur>() {
            @Override
            public void onResponse(Call<Donatur> call, Response<Donatur> response) {
                item.addAll(response.body().getData());
                donaturRelawanAdapter = new DonaturRelawanAdapter(item, getActivity());
                recyclerViewDonatur.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerViewDonatur.setAdapter(donaturRelawanAdapter);



            }

            @Override
            public void onFailure(Call<Donatur> call, Throwable t) {

            }
        });*/

    }

}
