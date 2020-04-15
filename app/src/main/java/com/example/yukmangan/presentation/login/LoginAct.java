package com.example.yukmangan.presentation.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yukmangan.api.ApiService;
import com.example.yukmangan.network.api.ApiEndpoint;
import com.example.yukmangan.network.api.ApiServiceAll;
import com.example.yukmangan.presentation.home.DashboardAct;
import com.example.yukmangan.R;
import com.example.yukmangan.apiInterface.LoginInterface;
import com.example.yukmangan.helper.PreferenceHelper;
import com.example.yukmangan.presentation.register.RegisterAct;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.sql.PreparedStatement;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class LoginAct extends AppCompatActivity {
    private Button btn_masuk;
    private EditText et_email,et_password;
    PreferenceHelper preferenceHelper;
    TextView tv_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceHelper=new PreferenceHelper(this);
        preferenceHelper = new PreferenceHelper(this);
        if (preferenceHelper.getIsLogin()){
            startActivity(new Intent(LoginAct.this, DashboardAct.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
        setContentView(R.layout.activity_login);
        et_email=findViewById(R.id.etemail);
        et_password=findViewById(R.id.etpassword);
        btn_masuk=findViewById(R.id.btn_masuk);
        btn_masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(LoginAct.this,DashboardAct.class);
               startActivity(intent);
                //loginUser();
            }
        });
        tv_register=findViewById(R.id.tv_register);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regist= new Intent(LoginAct.this, RegisterAct.class);
                startActivity(regist);
            }
        });

    }
    private void loginUser() {
        final String email = et_email.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        Retrofit retrofit= ApiServiceAll.getRetrofitService();
        ApiEndpoint apiEndpoint=retrofit.create(ApiEndpoint.class);
        Call<ResponseBody> call=apiEndpoint.getUserLogin(email,password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        assert response.body() != null;
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.get("status ").equals("true")) {
                            Log.i("If Status", "berhasil");
                            Intent intent = new Intent(LoginAct.this, DashboardAct.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            preferenceHelper.putIsLogin(true);
                            String id = jsonObject.getJSONObject("data").get("id").toString();
                            String nama = jsonObject.getJSONObject("data").get("nama_lengkap").toString();
                            String alamat = jsonObject.getJSONObject("data").get("alamat").toString();
                            String email = jsonObject.getJSONObject("data").get("email").toString();
                            String jk = jsonObject.getJSONObject("data").get("jk").toString();
                            //String nama=jsonObject.getJSONObject("id").toString();
                            //String id=jsonObject.getJSONObject("data").getJSONObject("id").toString();
                            preferenceHelper.putName(nama);
                            preferenceHelper.putId(id);
                            preferenceHelper.putEmail(email);
                            preferenceHelper.putAlamat(alamat);
                            preferenceHelper.putJk(jk);
                            Log.d("id", preferenceHelper.getID());
                            Log.d("nama", preferenceHelper.getName());
                            Log.d("email", preferenceHelper.getEMAIL());
                            Log.d("jk", preferenceHelper.getJk());
                            Log.d("alamat", preferenceHelper.getAlamat());
                            //preferenceHelper.putHobby(id);

                        } else if (jsonObject.get("Status  ").toString().equals("false")) {
                            Toast.makeText(LoginAct.this, jsonObject.getJSONObject("data").toString(), Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }


});

}
}