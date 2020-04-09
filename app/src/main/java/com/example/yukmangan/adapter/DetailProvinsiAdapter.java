package com.example.yukmangan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yukmangan.R;
import com.example.yukmangan.model.ProvinsiModel;

import java.util.ArrayList;

public class DetailProvinsiAdapter extends RecyclerView.Adapter<DetailProvinsiAdapter.ViewHolder> {
    private ArrayList<ProvinsiModel> list=new ArrayList<>();

    public DetailProvinsiAdapter() {

    }

    public void setProvinsiModel(ArrayList<ProvinsiModel> items) {
       if (list !=null){
           if (list.size()>0){
               list.clear();
           }
           list.addAll(items);
       }
       notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_data_provinsi,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.tv_provinsi.setText(list.get(position).getAttributes().getProvinsi());
            holder.tv_Confirmed.setText(list.get(position).getAttributes().getKasus_Posi());
            holder.tv_Recovered.setText(list.get(position).getAttributes().getKasus_Semb());
            holder.tv_Deaths.setText(list.get(position).getAttributes().getKasus_Meni());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_provinsi,tv_Confirmed,tv_Recovered,tv_Deaths;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_Confirmed=itemView.findViewById(R.id.tv_Confirmed);
            tv_provinsi=itemView.findViewById(R.id.tv_provinsi);
            tv_Recovered=itemView.findViewById(R.id.tv_Recovered);
            tv_Deaths=itemView.findViewById(R.id.tv_Deaths);
        }
    }
}
