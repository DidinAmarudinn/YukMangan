package com.example.yukmangan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yukmangan.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_masuk,btn_daftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_daftar=findViewById(R.id.btn_daftar);
        btn_masuk=findViewById(R.id.btn_masuk);
        btn_masuk.setOnClickListener(this);
        btn_daftar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_masuk:
                Intent masuk=new Intent(MainActivity.this,LoginAct.class);
                startActivity(masuk);
                break;
            case R.id.btn_daftar:
                Intent daftar=new Intent(MainActivity.this,RegisterAct.class);
                startActivity(daftar);
                break;
        }
    }
}
