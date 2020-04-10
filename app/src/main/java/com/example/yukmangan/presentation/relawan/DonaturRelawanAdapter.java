package com.example.yukmangan.presentation.relawan;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yukmangan.R;
import com.example.yukmangan.network.model.donatur.Datum;

import java.util.ArrayList;
import java.util.List;

public class DonaturRelawanAdapter extends RecyclerView.Adapter<DonaturRelawanAdapter.DonaturViewHolder> {
    private List<Datum> list;
    private final int limit = 10;

    public DonaturRelawanAdapter(List<Datum> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DonaturViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_warga_donasi_dashboard, parent, false);
        return new DonaturViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DonaturViewHolder holder, int position) {
        //Datum data = list.get(position);
        Log.e("CEK_POSITION",list.get(position).getNamaLengkap().toString());
        holder.nama.setText(list.get(position).getNamaLengkap().toString());
        holder.alamat.setText("Rp. "+list.get(position).getJumlahDonasi().toString());

    }

    @Override
    public int getItemCount() {
        if(list.size() > limit){
            return limit;
        }
        else
        {
            return list.size();
        }
    }

    public class DonaturViewHolder extends RecyclerView.ViewHolder {
        TextView nama, alamat;

        public DonaturViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.tv_name_warga);
            alamat = itemView.findViewById(R.id.tv_alamat_warga);
        }
    }
}
