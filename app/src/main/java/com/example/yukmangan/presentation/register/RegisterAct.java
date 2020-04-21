 // Updated upstream:app/src/main/java/com/example/yukmangan/presentation/register/RegisterAct.java
package com.example.yukmangan.presentation.register;;
// Stashed changes:app/src/main/java/com/example/yukmangan/activity/RegisterAct.java

import androidx.appcompat.app.AppCompatActivity;

 import android.app.ProgressDialog;
 import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
 import android.util.Patterns;
 import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

 import com.example.yukmangan.network.api.ApiEndpoint;
 import com.example.yukmangan.network.api.ApiServiceAll;
 import com.example.yukmangan.presentation.home.DashboardAct;
import com.example.yukmangan.R;
 import com.example.yukmangan.helper.PreferenceHelper;
import com.example.yukmangan.presentation.login.LoginAct;

 import org.json.JSONException;
import org.json.JSONObject;

 import java.io.IOException;

 import okhttp3.ResponseBody;
 import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

 public class RegisterAct extends AppCompatActivity {
    private EditText et_email, et_name, et_alamat, et_password;
    private PreferenceHelper preferenceHelper;
    private Button btn_daftar;
    private ProgressDialog progressDialog;
    private TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceHelper = new PreferenceHelper(this);
        if (preferenceHelper.getIsLogin()) {
            startActivity(new Intent(RegisterAct.this, DashboardAct.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }
        setContentView(R.layout.activity_register);
        et_alamat = findViewById(R.id.et_alamat);
        et_email = findViewById(R.id.et_email);
        et_name = findViewById(R.id.et_nama);
        et_password = findViewById(R.id.et_password);

        btn_daftar = findViewById(R.id.btn_daftar);
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
        tv_login = findViewById(R.id.tv_login);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(RegisterAct.this, LoginAct.class);
                startActivity(login);
            }
        });
    }
    private void signUp(){
        if (validate() == false){
            sifnupFailed();
        }else {
            registerMe();
        }

    }
    private void registerMe() {
        final String name = et_name.getText().toString();
        final String email = et_email.getText().toString();
        final String alamat = et_alamat.getText().toString();
        final String password = et_password.getText().toString();
        final String id_provinsi = "";
        final String id_kabupaten = "";
        final String id_kecamatan = "";
        final String id_desa = "";
        final String id_pekerjaan = "";
        final String id_jabatan = "";
        final String id_pendaftar_skill = "";
        final String no_wa = "";
        final String rw = "";
        final String rt = "";
        final String no_ktp = "";
        final String tempat_lahir = "";
        final String tgl_lahir = "";
        final String jk = "";
        final String tgl_daftar="";
        final String siap_relawan="";
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Mohon tunggu!!");
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        showDialog();
        Retrofit retrofit = ApiServiceAll.getRetrofitService();
        ApiEndpoint apiEndpoint = retrofit.create(ApiEndpoint.class);
        Call<ResponseBody> call = apiEndpoint.getUserRegister(name, email, alamat, password, id_provinsi, id_kabupaten, id_kecamatan, id_desa, id_pekerjaan, id_jabatan,
                id_pendaftar_skill, no_wa, rw, rt, no_ktp, tempat_lahir, tgl_lahir, jk,siap_relawan,tgl_daftar);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String respn=response.body().string().toString();
                        JSONObject jsonObject=new JSONObject(respn);
                        if (jsonObject.getString("status").equals("true")) {
                            hiddenDialog();
                            Log.i("If Status", "berhasil");
                            Toast.makeText(RegisterAct.this,"Register Berhasil",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterAct.this, LoginAct.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(RegisterAct.this,jsonObject.get("data").toString(),Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                hiddenDialog();
            }
        });


    }
    private void showDialog(){
        if (!progressDialog.isShowing());
        progressDialog.show();
    }
    private void hiddenDialog(){
        if (progressDialog.isShowing());
        progressDialog.dismiss();
    }
    private void signupSucces(){
        btn_daftar.setEnabled(true);
        finish();
    }
    public void sifnupFailed(){
        btn_daftar.setEnabled(true);
        Toast.makeText(RegisterAct.this,"Daftar Gagal!",Toast.LENGTH_LONG).show();
    }
    private boolean validate(){
        boolean valid=true;
        final String name = et_name.getText().toString();
        final String email = et_email.getText().toString();
        final String alamat = et_alamat.getText().toString();
        final String password = et_password.getText().toString();
        if (name.isEmpty() || name.length()<2){
            et_name.setError("masukan nama dengan benar");
            valid=false;
        }else {
            et_name.setError(null);
        }
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            et_email.setError("masukan email dengan benar");
            valid=false;
        }else {
            et_email.setError(null);
        }
        if (alamat.isEmpty() || alamat.length()<5){
            et_alamat.setError("masukan alamat dengan benar");
            valid=false;
        }else {
            et_alamat.setError(null);
        }
        if (password.isEmpty() || password.length()<8){
            et_password.setError("password harus lebih dari 8 huruf");
            valid=false;
        }else {
            et_password.setError(null);
        }
        return valid;
    }
}
