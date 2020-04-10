package com.example.yukmangan.presentation.home;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yukmangan.R;
import com.example.yukmangan.adapter.DetailBeritaAdapter;
import com.example.yukmangan.adapter.DetailProvinsiAdapter;
import com.example.yukmangan.network.model.BeritaModel;
import com.example.yukmangan.network.model.ProvinsiModel;
import com.example.yukmangan.viewmodel.BeritaViewModel;
import com.example.yukmangan.viewmodel.ProvinsiViewModel;

import java.util.ArrayList;

public class NewsAct extends AppCompatActivity {
    private RecyclerView rv_berita;
    ProgressDialog progressDialog;
    DetailBeritaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        rv_berita=findViewById(R.id.rv_berita);
        adapter=new DetailBeritaAdapter();
        progressDialog=new ProgressDialog(this);
        rv_berita.setLayoutManager(new LinearLayoutManager(this));
        rv_berita.setHasFixedSize(true);
        rv_berita.setAdapter(adapter);
        loadListData();
    }
    private void loadListData() {
        BeritaViewModel viewModel=new ViewModelProvider(this,
                new ViewModelProvider.NewInstanceFactory()).get(BeritaViewModel.class);
        viewModel.setDataBerita();
        progressDialog.show();
        viewModel.setDataBerita();
        viewModel.getBeritaData().observe(this, new Observer<ArrayList<BeritaModel>>() {
            @Override
            public void onChanged(ArrayList<BeritaModel> beritaModels) {
                adapter.setBerita(beritaModels);
                progressDialog.dismiss();
            }
        });
    }
}
