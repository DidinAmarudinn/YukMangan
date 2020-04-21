package com.example.yukmangan.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yukmangan.R;
import com.example.yukmangan.network.model.BeritaModel;
import com.example.yukmangan.presentation.home.DetailNews;

import java.util.ArrayList;
import java.util.Collection;

public class DetailBeritaAdapter extends RecyclerView.Adapter<DetailBeritaAdapter.ViewHolder> {
    Context context;
   private ArrayList<BeritaModel> list=new ArrayList<>();
   public void setBerita(ArrayList<BeritaModel> items){
       if (list != null){
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
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       final String url="https://yukmangan.id/dapurmangan/assets/upload/blog/artikel/"+list.get(position).getFilefoto();
        Glide.with(holder.itemView.getContext())
               .load(url)
                .centerCrop()
                .into(holder.img_berita);
        holder.tv_kategori.setText(list.get(position).getIdTags());
        holder.tv_title_berita.setText(list.get(position).getJudulArtikel());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.itemView.getContext(), DetailNews.class);
                intent.putExtra("title_artikel",list.get(position).getJudulArtikel());
                intent.putExtra("isi_artikel",list.get(position).getIsiArtikel());
                intent.putExtra("kategori",list.get(position).getIdTags());
                intent.putExtra("foto",list.get(position).getFilefoto());
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title_berita,tv_kategori;
        ImageView img_berita;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_kategori=itemView.findViewById(R.id.tv_kategori);
            tv_title_berita=itemView.findViewById(R.id.tv_title_berita);
            img_berita=itemView.findViewById(R.id.img_berita);
        }
    }
}
