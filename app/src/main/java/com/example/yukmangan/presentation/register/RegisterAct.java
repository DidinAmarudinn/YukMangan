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

 import com.example.yukmangan.network.api.ApiEndpoint;
 import com.example.yukmangan.network.api.ApiServiceAll;
 import com.example.yukmangan.presentation.home.DashboardAct;
import com.example.yukmangan.R;
import com.example.yukmangan.network.apiInterface.RegisterInterface;
import com.example.yukmangan.helper.PreferenceHelper;
import com.example.yukmangan.presentation.login.LoginAct;
 import com.google.gson.JsonObject;

 import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

 import java.io.IOException;

 import okhttp3.ResponseBody;
 import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RegisterAct extends AppCompatActivity {
    private EditText et_email, et_name, et_alamat, et_password;
    private PreferenceHelper preferenceHelper;
    private Button btn_daftar;
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
                registerMe();
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
        final String id_pendaftar_skill = "4";
        final String no_wa = "087";
        final String rw = "1";
        final String rt = "42";
        final String no_ktp = "452";
        final String tempat_lahir = "test";
        final String tgl_lahir = "2020-04-10";
        final String jk = "L";
        final String tgl_daftar="";
        final String siap_relawan="Y";

        Retrofit retrofit = ApiServiceAll.getRetrofitService();
        ApiEndpoint apiEndpoint = retrofit.create(ApiEndpoint.class);
        Call<ResponseBody> call = apiEndpoint.getUserRegister(name, email, alamat, password, id_provinsi, id_kabupaten, id_kecamatan, id_desa, id_pekerjaan, id_jabatan,
                id_pendaftar_skill, no_wa, rw, rt, no_ktp, tempat_lahir, tgl_lahir, jk,siap_relawan,tgl_daftar);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        Log.i("debug berhasil", response.body().string());
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        if (jsonObject.getJSONObject("status").equals("true")) {
                            Log.i("If Status", "berhasil");
                            Intent intent = new Intent(RegisterAct.this, DashboardAct.class);
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

            }
        });
    /*private void parseRegData(String response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response);
        if (jsonObject.get("status").equals("true")){
            Log.e("saveInfo",response.toString());
            Toast.makeText(RegisterAct.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RegisterAct.this,DashboardAct.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            preferenceHelper.putIsLogin(true);
            String id=jsonObject.getJSONObject("data").get("id").toString();
            String nama=jsonObject.getJSONObject("data").get("nama_lengkap").toString();
            String alamat=jsonObject.getJSONObject("data").get("alamat").toString();
            String email=jsonObject.getJSONObject("data").get("email").toString();
            String jk=jsonObject.getJSONObject("data").get("jk").toString();
            //String nama=jsonObject.getJSONObject("id").toString();
            //String id=jsonObject.getJSONObject("data").getJSONObject("id").toString();
            preferenceHelper.putName(nama);
            preferenceHelper.putId(id);
            preferenceHelper.putEmail(email);
            preferenceHelper.putAlamat(alamat);
            preferenceHelper.putJk(jk);
            Log.d("id",preferenceHelper.getID());
            Log.d("nama",preferenceHelper.getName());
            Log.d("email",preferenceHelper.getEMAIL());
            Log.d("jk",preferenceHelper.getJk());
            Log.d("alamat",preferenceHelper.getAlamat());
        }else {
            Toast.makeText(RegisterAct.this, jsonObject.get("data").toString(), Toast.LENGTH_SHORT).show();
        }
    }
*/

    }
}
