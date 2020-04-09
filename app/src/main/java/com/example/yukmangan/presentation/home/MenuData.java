package com.example.yukmangan.presentation.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.yukmangan.R;
import com.example.yukmangan.adapter.DetailProvinsiAdapter;
import com.example.yukmangan.network.model.ProvinsiModel;
import com.example.yukmangan.viewmodel.ProvinsiViewModel;

import java.util.ArrayList;

public class MenuData extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private RecyclerView rv_provinsi;
    private DetailProvinsiAdapter detailProvinsiAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_data);
            progressDialog=new ProgressDialog(this);
            rv_provinsi=findViewById(R.id.rv_provinsi);
            detailProvinsiAdapter=new DetailProvinsiAdapter();
            rv_provinsi.setLayoutManager(new LinearLayoutManager(this));
            rv_provinsi.setAdapter(detailProvinsiAdapter);
            loadListData();
        }
        private void loadListData() {
            ProvinsiViewModel viewModel=new ViewModelProvider(this,
                    new ViewModelProvider.NewInstanceFactory()).get(ProvinsiViewModel.class);
            viewModel.setProvinsiData();
            progressDialog.show();
            viewModel.setProvinsiData();
            viewModel.getProvinsiData().observe(this, new Observer<ArrayList<ProvinsiModel>>() {
                @Override
                public void onChanged(ArrayList<ProvinsiModel> provinsiModels) {
                    detailProvinsiAdapter.setProvinsiModel(provinsiModels);
                    progressDialog.dismiss();
                }
            });
        }
    }

