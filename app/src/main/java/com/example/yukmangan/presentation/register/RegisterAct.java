// Updated upstream:app/src/main/java/com/example/yukmangan/presentation/register/RegisterAct.java
package com.example.yukmangan.presentation.register;;
// Stashed changes:app/src/main/java/com/example/yukmangan/activity/RegisterAct.java

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yukmangan.presentation.home.DashboardAct;
import com.example.yukmangan.R;
import com.example.yukmangan.network.apiInterface.RegisterInterface;
import com.example.yukmangan.helper.PreferenceHelper;
import com.example.yukmangan.presentation.login.LoginAct;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RegisterAct extends AppCompatActivity {
    private EditText et_email,et_name,et_alamat,et_password;
    private PreferenceHelper preferenceHelper;
    private Button btn_daftar;
    private TextView tv_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceHelper = new PreferenceHelper(this);
        if (preferenceHelper.getSPSudahLogin()){
                    startActivity(new Intent(RegisterAct.this, DashboardAct.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                    finish();
        }
        setContentView(R.layout.activity_register);
        et_alamat=findViewById(R.id.et_alamat);
        et_email=findViewById(R.id.et_email);
        et_name=findViewById(R.id.et_nama);
        et_password=findViewById(R.id.et_password);

        btn_daftar=findViewById(R.id.btn_daftar);
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerMe();
            }
        });
        tv_login=findViewById(R.id.tv_login);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login=new Intent(RegisterAct.this, LoginAct.class);
                startActivity(login);
            }
        });
    }
    private void registerMe() {
        final String name = et_name.getText().toString();
        final String email = et_email.getText().toString();
        final String alamat = et_alamat.getText().toString();
        final String password = et_password.getText().toString();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RegisterInterface.REGISTRASI_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        RegisterInterface api = retrofit.create(RegisterInterface.class);
        Call<String> call = api.getUserRegister(name,email,alamat,password);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //Toast.makeText()
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i("onSuccess", response.body().toString());
                        String jsonresponse = response.body().toString();
                        try {
                            parseRegData(jsonresponse);
                            Toast.makeText(RegisterAct.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterAct.this,DashboardAct.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    } else {
                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
    }
    private void parseRegData(String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.optString("status").equals("true")){
            saveInfo(response);

        }else {
            Toast.makeText(RegisterAct.this, jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
        }
    }

    private void saveInfo(String response){
        preferenceHelper.saveSPBoolean(PreferenceHelper.SP_SUDAH_LOGIN,true);
        try {
            JSONObject jsonObject = new JSONObject(response);
            if (jsonObject.getString("status").equals("true")) {
                JSONArray dataArray = jsonObject.getJSONArray("data");
                for (int i = 0; i < dataArray.length(); i++) {
                    JSONObject dataobj = dataArray.getJSONObject(i);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
