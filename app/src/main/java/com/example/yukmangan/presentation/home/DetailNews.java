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
import com.example.yukmangan.adapter.DetailBeritaAdapter;
import com.example.yukmangan.helper.PreferenceHelper;
import com.squareup.picasso.Picasso;

public class DetailNews extends AppCompatActivity {
    private TextView tv_detail_title,tv_detail_kategori,tv_isi_artikel;
    private ImageView img_berita;
    private RelativeLayout btn_back;
    PreferenceHelper preferenceHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);
        btn_back=findViewById(R.id.btn_back);
        tv_detail_kategori=findViewById(R.id.tv_detail_kategori);
        tv_isi_artikel=findViewById(R.id.tv_isi_artikel);
        tv_detail_title=findViewById(R.id.tv_detail_title);
        preferenceHelper=new PreferenceHelper(this);
        img_berita=findViewById(R.id.img_detail_berita);
        String kategori=getIntent().getExtras().getString("kategori");
        String isi_artikel=getIntent().getExtras().getString("isi_artikel");
        String title_artikel=getIntent().getExtras().getString("title_artikel");
        String image_artikel=getIntent().getExtras().getString("foto");
        final String url="https://yukmangan.id/dapurmangan/assets/upload/blog/artikel/"+image_artikel;
        Glide.with(DetailNews.this).load(url).centerCrop().into(img_berita);
        tv_detail_title.setText(title_artikel);
        tv_isi_artikel.setText(isi_artikel);
        tv_detail_kategori.setText(kategori);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DetailNews.this,NewsAct.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
