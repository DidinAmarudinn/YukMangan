package com.example.yukmangan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yukmangan.DashboardAct;
import com.example.yukmangan.R;
import com.example.yukmangan.apiInterface.RegisterInterface;
import com.example.yukmangan.helper.PreferenceHelper;
import com.google.gson.JsonObject;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferenceHelper = new PreferenceHelper(this);
        if (preferenceHelper.getSPSudahLogin()){
            preferenceHelper.saveSPBoolean(PreferenceHelper.SP_NAMA,true);
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
                Intent intent=new Intent(RegisterAct.this,DashboardAct.class);
                startActivity(intent);
                RegisterAct.this.finish();
                //registMe();
            }
        });

    }
    private void registMe(){
        final String nama_lengkap=et_name.getText().toString();
        final String email=et_email.getText().toString();
        final String alamat=et_alamat.getText().toString();
        final String password=et_password.getText().toString();


        Retrofit  retrofit   =   new   Retrofit . Builder ()
                . baseUrl ( RegisterInterface . REGISTRASI_URL )
                . addConverterFactory ( ScalarsConverterFactory. create () )
                . build () ;

        RegisterInterface api= retrofit.create(RegisterInterface.class);
        Call<String> call=api.getUserRegister(nama_lengkap,email,alamat,password);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()){
                        if (response.body() !=null){
                            Log.i("OnSucces",response.body().toString());

                            String jsrespone=response.body().toString();
                           try {
                               ParseRegData(jsrespone);
                               Intent intent=new Intent(RegisterAct.this,DashboardAct.class);
                               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                               startActivity(intent);
                               finish();
                           } catch (Exception e) {
                               e.printStackTrace();
                           }
                        }else {
                            Log.i("On EmptyRespone","Return empety respone");
                        }
                    }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });

    }

    private void ParseRegData(String respone) throws JSONException{
        JSONObject jsonObject=new JSONObject(respone);
        if (jsonObject.optString("status").equals("true")){
            saveInfo(respone);
            Toast.makeText(RegisterAct.this,"Registrasi Berhasil",Toast.LENGTH_SHORT).show();

        }
    }

    private void saveInfo(String respone) {
        try {
            JSONObject jsonObject=new JSONObject(respone);
            if (jsonObject.getString("status").equals("true")){
                JSONArray jsonArray=jsonObject.getJSONArray("data");
                for (int i=0; i<jsonArray.length(); i++){
                    JSONObject dataobj=jsonArray.getJSONObject(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
