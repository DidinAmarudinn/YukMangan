package com.example.yukmangan.presentation.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.yukmangan.R;
import com.example.yukmangan.network.model.IndoneisaModel;
import com.example.yukmangan.activity.MenuData;
import com.example.yukmangan.viewmodel.IndonesiaViewModel;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private ProgressDialog mProgressApp;
    LinearLayout menu_data;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        mProgressApp = new ProgressDialog(getActivity());
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        String currentDate=simpleDateFormat.format(new Date());
        mProgressApp.setTitle("Please Wait");
        mProgressApp.setCancelable(true);
        mProgressApp.setMessage("Show Data");
        menu_data=view.findViewById(R.id.menu_data);
        mProgressApp.show();
        menu_data.setOnClickListener(this);
        final PieChart pieChart=view.findViewById(R.id.piechart);
        IndonesiaViewModel viewModel=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).
                get(IndonesiaViewModel.class);
        viewModel.setCountryData();
        viewModel.getCountryData().observe(this, new Observer<IndoneisaModel>() {
            @Override
            public void onChanged(IndoneisaModel indoneisaModel) {
                mProgressApp.dismiss();
                List<PieEntry> pieEntries=new ArrayList<>();
                pieEntries.add(new PieEntry(Float.parseFloat(indoneisaModel.getIdnConfirmed().getValue())));
                pieEntries.add(new PieEntry(Float.parseFloat(indoneisaModel.getIdnRecovered().getValue())));
                pieEntries.add(new PieEntry(Float.parseFloat(indoneisaModel.getIdnDeaths().getValue())));
                ArrayList<Integer> colors=new ArrayList<>();
                colors.add(Color.rgb(84,216,254));
                colors.add(Color.rgb(164,148,187));
                colors.add(Color.rgb(254,131,115));
                PieDataSet pieDataSet=new PieDataSet(pieEntries,"Covid19");
                pieDataSet.setColors(colors);
                pieDataSet.setValueTextColor(Color.WHITE);
                pieDataSet.setValueTextSize(14);
                Description description=new Description();
                description.setText("Tanggal "+": "+currentDate);
                PieData pieData=new PieData(pieDataSet);
                pieChart.setVisibility(View.VISIBLE);
                pieChart.animateXY(2000,2000);
                pieChart.setData(pieData);
                pieChart.setDescription(description);

            }
        });
                return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_data:
                Intent menudata=new Intent(getActivity(), MenuData.class);
                startActivity(menudata);
                break;
        }
    }
}
