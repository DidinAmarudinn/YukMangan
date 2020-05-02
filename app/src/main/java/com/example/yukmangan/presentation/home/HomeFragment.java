package com.example.yukmangan.presentation.home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yukmangan.R;
import com.example.yukmangan.helper.PreferenceHelper;
import com.example.yukmangan.network.api.ApiEndpoint;
import com.example.yukmangan.network.api.ApiServiceAll;
import com.example.yukmangan.network.model.IndoneisaModel;
import com.example.yukmangan.viewmodel.IndonesiaViewModel;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private ProgressDialog mProgressApp;
    private Button btn_selengkapnya;
    private PreferenceHelper preferenceHelper;
    LinearLayout menu_data,menu_news;
    private ImageView img_gabung_rw;
    ImageView ic_setting;
    private TextView tv_get_countrelawan,rw_bergabung;
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
        preferenceHelper=new PreferenceHelper(getContext());
        mProgressApp.setTitle("Please Wait");
        mProgressApp.setCancelable(true);
        mProgressApp.setMessage("Show Data");
        tv_get_countrelawan=view.findViewById(R.id.count_relawan);
        rw_bergabung=view.findViewById(R.id.rw_bergabung);
        menu_data=view.findViewById(R.id.menu_data);
        img_gabung_rw=view.findViewById(R.id.img_gabung_rw);
        menu_news=view.findViewById(R.id.menu_news);
        ic_setting = view.findViewById(R.id.ic_setting);
        getRelawanCount();
        getRwCount();
        mProgressApp.show();
        menu_data.setOnClickListener(this);
        img_gabung_rw.setOnClickListener(this);
        menu_news.setOnClickListener(this);
        ic_setting.setOnClickListener(this);
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
                description.setText(" Tanggal "+": "+currentDate);
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
            case R.id.btn_selengkapnya:
                break;
            case R.id.menu_news:
                Intent menunews=new Intent(getActivity(),NewsAct.class);
                startActivity(menunews);
                break;
            case R.id.ic_setting:
                Intent act=new Intent(getActivity(),Profile.class);
                startActivity(act);
                break;
            case R.id.img_gabung_rw:
                Intent gabung_rw=new Intent(getActivity(), ValidasiRw.class);
                startActivity(gabung_rw);
                break;
        }
    }
    public void getRelawanCount(){
        Retrofit retrofit= ApiServiceAll.getRetrofitService();
        ApiEndpoint apiEndpoint=retrofit.create(ApiEndpoint.class);
        Call<ResponseBody> call=apiEndpoint.getCountRelawan();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){
                    try {
                        JSONObject jsonObject=new JSONObject(response.body().string());
                        if (jsonObject.get("status").toString().equals("true")){
                            JSONArray jsonArray=jsonObject.getJSONArray("data");
                            for (int i=0; i<jsonArray.length(); i++){
                                JSONObject data=jsonArray.getJSONObject(i);
                                String countRelawan=data.getString("Total").toString();
                                tv_get_countrelawan.setText(countRelawan+" "+"RELAWAN");
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });
    }
    public void getRwCount(){
        Retrofit retrofit=ApiServiceAll.getRetrofitService();
        ApiEndpoint apiEndpoint=retrofit.create(ApiEndpoint.class);
        Call<ResponseBody> call=apiEndpoint.getCountRw();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()){
                        try {
                            JSONObject jsonObject=new JSONObject(response.body().string());
                            if (jsonObject.getBoolean("status") == true){
                                String totalrw=jsonObject.getJSONObject("Pesan").get("Total_relawan").toString();
                                rw_bergabung.setText(totalrw+" "+"RW BERGABUNG");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }


}
