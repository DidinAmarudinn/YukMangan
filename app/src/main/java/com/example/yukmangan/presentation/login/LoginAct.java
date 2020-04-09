package com.example.yukmangan.presentation.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.yukmangan.presentation.DashboardAct;
import com.example.yukmangan.R;
import com.example.yukmangan.helper.PreferenceHelper;

public class LoginAct extends AppCompatActivity {
    private Button btn_masuk;
    PreferenceHelper preferenceHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceHelper=new PreferenceHelper(this);

        setContentView(R.layout.activity_login);
        btn_masuk=findViewById(R.id.btn_masuk);
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginAct.this, DashboardAct.class);
                startActivity(intent);
            }
        });
    }
}
