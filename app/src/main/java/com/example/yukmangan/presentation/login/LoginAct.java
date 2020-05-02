package com.example.yukmangan.presentation.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
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
    private ProgressDialog progressDialog;
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
               //Intent intent=new Intent(LoginAct.this,DashboardAct.class);
               //startActivity(intent);
                login();
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
    private void login(){
        if (validate()==false){
            loginFailed();
            return;
        }
        loginUser();

    }
    private void loginUser() {
        final String email = et_email.getText().toString().trim();
        final String password = et_password.getText().toString().trim();
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Login........");
        progressDialog.setCancelable(true);
        showDialog();
        Retrofit retrofit= ApiServiceAll.getRetrofitService();
        ApiEndpoint apiEndpoint=retrofit.create(ApiEndpoint.class);
        Call<ResponseBody> call=apiEndpoint.getUserLogin(email,password);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                hiedeDialog();
                if (response.isSuccessful()) {
                    try {
                        assert response.body() != null;
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.get("status").equals("true")) {
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
                            String id_rw=jsonObject.getJSONObject("data").get("rw").toString();
                            //String nama=jsonObject.getJSONObject("id").toString();
                            //String id=jsonObject.getJSONObject("data").getJSONObject("id").toString();
                            preferenceHelper.putName(nama);
                            preferenceHelper.putId(id);
                            preferenceHelper.putEmail(email);
                            preferenceHelper.putAlamat(alamat);
                            preferenceHelper.putJk(jk);
                            preferenceHelper.putId_rw(id_rw);
                            Log.d("id", preferenceHelper.getID());
                            Log.d("nama", preferenceHelper.getName());
                            Log.d("email", preferenceHelper.getEMAIL());
                            Log.d("id_rw", preferenceHelper.getID_RW());
                            Log.d("jk", preferenceHelper.getJk());
                            Log.d("alamat", preferenceHelper.getAlamat());
                            //preferenceHelper.putHobby(id);
                            Toast.makeText(LoginAct.this,"ID_RW"+preferenceHelper.getID_RW(),Toast.LENGTH_LONG).show();
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
                hiedeDialog();
            }


});

}
    private void showDialog(){
        if (!progressDialog.isShowing())
            progressDialog.show();

    }
    private void hiedeDialog(){
        if (progressDialog.isShowing())
            progressDialog.dismiss();

    }
    private void loginSucces(){
        btn_masuk.setEnabled(true);
    }
    private void loginFailed(){
        Toast.makeText(LoginAct.this,"Login Fiailed",Toast.LENGTH_LONG).show();
        btn_masuk.setEnabled(true);
    }
    private boolean validate(){
        boolean valid=true;
        String email=et_email.getText().toString();
        String pasword=et_password.getText().toString();

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_email.setError("masukan email dengan benar");
            requestFocus(et_email);
            valid=false;
        }else {
            et_email.setError(null);
        }
        if (pasword.isEmpty()){
            et_password.setError("masukan password");
            requestFocus(et_password);
            valid=false;
        }else {
            et_password.setError(null);
        }

        return valid;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

}