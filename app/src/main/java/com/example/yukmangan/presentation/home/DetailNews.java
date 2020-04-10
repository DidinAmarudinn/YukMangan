package com.example.yukmangan.presentation.home;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.yukmangan.R;

public class DetailNews extends AppCompatActivity {
    private TextView tv_detail_title,tv_detail_kategori,tv_isi_artikel;
    private ImageView img_berita;
    private RelativeLayout btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        btn_back=findViewById(R.id.btn_back);
        tv_detail_kategori=findViewById(R.id.tv_detail_kategori);
        tv_isi_artikel=findViewById(R.id.tv_isi_artikel);
        tv_detail_title=findViewById(R.id.tv_detail_title);
        img_berita=findViewById(R.id.img_berita);

        String kategori=getIntent().getExtras().getString("kategori");
        String isi_artikel=getIntent().getExtras().getString("isi_artikel");
        String title_artikel=getIntent().getExtras().getString("title_artikel");
        int image_berita=getIntent().getExtras().getInt("image_artikel");

        tv_detail_title.setText(title_artikel);
        tv_isi_artikel.setText(isi_artikel);
        tv_detail_kategori.setText(kategori);
        img_berita.setImageResource(image_berita);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailNews.this,NewsAct.class);
                startActivity(intent);
            }
        });
    }
}
