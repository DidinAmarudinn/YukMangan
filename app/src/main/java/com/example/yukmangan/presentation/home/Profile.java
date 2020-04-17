package com.example.yukmangan.presentation.home;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.yukmangan.R;

public class Profile extends AppCompatActivity implements View.OnClickListener {
Button btn_profile_update,btn_log_out;
TextView txt_back;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        btn_profile_update = findViewById(R.id.btn_profile_update);
        txt_back = findViewById(R.id.txt_back);
        txt_back.setOnClickListener(this);
        btn_profile_update.setOnClickListener(this);
    }

    @Override
        public void onClick(View v) {
        if (v==btn_profile_update){
            Intent intent1 = new Intent(Profile.this,UpdateProfile.class);
            startActivity(intent1);
            finish();
        }
        if (v==txt_back){
            Intent intent1 = new Intent(Profile.this,DashboardAct.class);
            startActivity(intent1);
            finish();
        }
    }
}
