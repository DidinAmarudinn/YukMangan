package com.example.yukmangan.presentation.home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;
import com.example.yukmangan.R;
import com.example.yukmangan.api.RequestHandler;
import com.example.yukmangan.api.WebServiceApi;
import com.example.yukmangan.network.model.update_profile.Model_updt_profile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
public class UpdateProfile extends AppCompatActivity {
    public String prop_id= null;
    String kab_id = null;
    String kec_id = null;
    String des_id = null;
    ProgressDialog dialog;
    /*1*/
    AutoCompleteTextView edt_propinsi;
    ArrayAdapter adapter_propinsi;
    ArrayList<String>DROP_DOWN_PROPINSI= new ArrayList<String>();
    /*2*/
    AutoCompleteTextView edt_kabupaten;
    ArrayAdapter adapter_kabupaten;
    ArrayList<String>DROPDOWN_KABUPATEN= new ArrayList<String>();
    /*3*/
    AutoCompleteTextView edt_kec;
    ArrayAdapter adapter_kecamatan;
    ArrayList<String>DROPDOWN_KECAMATAN= new ArrayList<String>();
    /*4*/
    AutoCompleteTextView edt_desa;
    ArrayAdapter adapter_desa;
    ArrayList<String>DROPDOWN_DESA= new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        dialog = new ProgressDialog(UpdateProfile.this);
        /*1*/
        edt_propinsi = (AutoCompleteTextView) findViewById(R.id.edt_cari_propinsi);
        adapter_propinsi = new ArrayAdapter<>(UpdateProfile.this,R.layout.support_simple_spinner_dropdown_item,DROP_DOWN_PROPINSI);
        edt_propinsi.setAdapter(adapter_propinsi);
        /*2*/
        edt_kabupaten = (AutoCompleteTextView)findViewById(R.id.edt_cari_kabupaten);
        adapter_kabupaten = new ArrayAdapter<>(UpdateProfile.this,R.layout.support_simple_spinner_dropdown_item,DROPDOWN_KABUPATEN);
        edt_kabupaten.setAdapter(adapter_kabupaten);
        /*3*/
        edt_kec =  (AutoCompleteTextView) findViewById(R.id.edt_cari_kecamatan);
        adapter_kecamatan = new ArrayAdapter(UpdateProfile.this,R.layout.support_simple_spinner_dropdown_item,DROPDOWN_KECAMATAN);
        edt_kec.setAdapter(adapter_kecamatan);
        /*4*/
        edt_desa =  (AutoCompleteTextView) findViewById(R.id.edt_cari_desa);
        adapter_desa = new ArrayAdapter(UpdateProfile.this,R.layout.support_simple_spinner_dropdown_item,DROPDOWN_DESA);
        edt_desa.setAdapter(adapter_desa);

        edt_propinsi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                setPropinsi();
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                edt_propinsi.removeTextChangedListener(this);
                String nama = s.toString().trim();
                Log.d("","Nama"+nama);
                if (nama.equals("")){
                    Log.d("","Nama Kosong");
                }if(!nama.equals("")){
                    cari_props(nama);
                }

                Log.d("","Nama Propinsi"+nama);
                adapter_propinsi.notifyDataSetChanged();
                edt_propinsi.addTextChangedListener(this);
                edt_propinsi.setDropDownWidth(600);
            }
        });
        edt_propinsi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama_prop =(String) parent.getItemAtPosition(position);
                Log.d("","get id kabupaten = "+nama_prop);
                cari_props(nama_prop);
                get_kabupaten_by_id(prop_id);
                edt_propinsi.post(new Runnable() {
                    @Override
                    public void run() {
                        edt_propinsi.dismissDropDown();
                        edt_propinsi.setDropDownWidth(0);
                    }
                });
            }
        });

        edt_kabupaten.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (prop_id==null){
                }else{
                    get_kabupaten_by_id(prop_id);
                }
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                edt_kabupaten.removeTextChangedListener(this);
                String nama = s.toString().trim();
                Log.d("","Nama"+nama);
                if (nama.equals("")){
                    Log.d("","Nama Kosong");
                }if(!nama.equals("")){
                    get_kabupaten_by_nama(nama);
                }
                Log.d("","Nama kabupaten"+nama);
                adapter_kabupaten.notifyDataSetChanged();
                edt_kabupaten.addTextChangedListener(this);
                edt_kabupaten.setDropDownWidth(500);
            }
        });
        edt_kabupaten.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nama_kab =(String) parent.getItemAtPosition(position);
                Log.d("","get id kecamatan = "+nama_kab);
                get_kabupaten_by_nama(nama_kab);
                edt_kabupaten.post(new Runnable() {
                    @Override
                    public void run() {
                        edt_kabupaten.setDropDownWidth(0);
                        edt_kabupaten.dismissDropDown();
                    }
                });
            }
        });
        edt_kec.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt_kec.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        edt_desa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        edt_desa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

     void setPropinsi(){
        class propx extends AsyncTask<Void,Void,String>{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected String doInBackground(Void... voids) {
                RequestHandler handler = new RequestHandler();
                String get             = handler.sendGetRequest(WebServiceApi.API_URL_PROPINSI);
                return get;
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                DROP_DOWN_PROPINSI.clear();
                try {
                    JSONArray  jsonArray = new JSONArray(s);
                for (int i=0; i<jsonArray.length(); i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        String item= object.getString("nama");
                        String prop_id = object.getString("id");
                        DROP_DOWN_PROPINSI.add(item);
                    }
                        edt_propinsi.setAdapter(new ArrayAdapter<>(UpdateProfile.this,R.layout.support_simple_spinner_dropdown_item,DROP_DOWN_PROPINSI));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                edt_propinsi.showDropDown();
                            }
                        },100);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        propx x = new propx();
        x.execute();
    }

    void cari_props( String CARI_INDEX){
        final String nama= CARI_INDEX;
        class cari_data extends AsyncTask<Void,Void,String>{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected String doInBackground(Void... voids) {
                Log.d("","LOG CARI ="+nama);
                HashMap<String,String>index = new HashMap<>();
                index.put("nama",nama);
                RequestHandler requestHandler = new RequestHandler();
                String data   =  requestHandler.sendPostRequest(WebServiceApi.API_URL_PROPINSI_NAMA,index);
                return data;
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                DROP_DOWN_PROPINSI.clear();
                try {
                    JSONObject object = new JSONObject(s);
                    String status     = object.getString("status");
                    String data       = object.getString("data");
                    if (status.equals("true")){
                        JSONArray jsonArray = new JSONArray(data);
                        for (int i=0; i<jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            String index_props    = jsonObject.getString("nama");
                            prop_id               = jsonObject.getString("id");
                            DROP_DOWN_PROPINSI.add(index_props);
                            Log.d("","nama propinsi"+index_props);
                            Log.d("","ID  propinsi =====> "+prop_id);
                        }
                        edt_propinsi.setAdapter(new ArrayAdapter<>(UpdateProfile.this,R.layout.support_simple_spinner_dropdown_item,DROP_DOWN_PROPINSI));
                       new Handler().postDelayed(new Runnable() {
                           @Override
                           public void run() {
                               edt_propinsi.showDropDown();
                           }
                       },100);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        cari_data c = new cari_data();
        c.execute();
    }

    void get_kabupaten_by_id(String id_pr){
        id_pr = prop_id;
        String finalId_pr = id_pr;
        class kabupaten extends AsyncTask<Void,Void,String>{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String,String>index = new HashMap<>();
                index.put("provinsi_id", finalId_pr);
                return new RequestHandler().sendPostRequest(WebServiceApi.API_URL_GET_KBTN,index);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                DROPDOWN_KABUPATEN.clear();
                try {
                    JSONObject object = new JSONObject(s);
                    String data       = object.getString("data");
                    String status     = object.getString("status");
                    if (status.equals("true")){
                        JSONArray elements = new JSONArray(data);
                        for (int x=0; x<elements.length();x++){
                            JSONObject jsonObject = elements.getJSONObject(x);
                            String index   = jsonObject.getString("nama");
                            kab_id         = jsonObject.getString("id");
                            DROPDOWN_KABUPATEN.add(index);
                        }
                        edt_kabupaten.setAdapter(new ArrayAdapter<>(UpdateProfile.this,R.layout.support_simple_spinner_dropdown_item,DROPDOWN_KABUPATEN));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                edt_kabupaten.showDropDown();
                            }
                        },100);
                    }
                    if (status.equals("false")){
                        Toast.makeText(UpdateProfile.this, "Pesan "+data, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        kabupaten xx = new kabupaten();
        xx.execute();
    }

    void get_kabupaten_by_nama(String nama){
        class kabupaten extends AsyncTask<Void,Void,String>{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String,String>index = new HashMap<>();
                index.put("nama", nama);
                return new RequestHandler().sendPostRequest(WebServiceApi.API_URL_GET_NAMA_KBTN,index);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                DROPDOWN_KABUPATEN.clear();
                try {
                    JSONObject object = new JSONObject(s);
                    String data       = object.getString("data");
                    String status     = object.getString("status");
                    if (status.equals("true")){
                        JSONArray elements = new JSONArray(data);
                        for (int x=0; x<elements.length();x++){
                            JSONObject jsonObject   = elements.getJSONObject(x);
                            String index            = jsonObject.getString("nama");
                            kab_id                  = jsonObject.getString("id");
                            DROPDOWN_KABUPATEN.add(index);
                        }
                        edt_kabupaten.setAdapter(new ArrayAdapter<>(UpdateProfile.this,R.layout.support_simple_spinner_dropdown_item,DROPDOWN_KABUPATEN));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                edt_kabupaten.showDropDown();
                            }
                        },100);
                    }
                    if (status.equals("false")){
                        Toast.makeText(UpdateProfile.this, "Pesan "+data, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        kabupaten xx = new kabupaten();
        xx.execute();
    }

    void get_kec_by_id(String id){
        id = kab_id;
        String finalId = id;
        class kec extends AsyncTask<Void,Void,String>{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected String doInBackground(Void... voids) {
                HashMap<String,String>index = new HashMap<>();
                index.put("kabupaten_id", finalId);
                return new RequestHandler().sendPostRequest(WebServiceApi.API_URL_GET_KCMTN,index);
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                DROPDOWN_KECAMATAN.clear();
                try {
                    JSONObject object = new JSONObject(s);
                    String data       = object.getString("data");
                    String status     = object.getString("status");
                    if (status.equals("true")){
                        JSONArray elements = new JSONArray(data);
                        for (int x=0; x<elements.length();x++){
                            JSONObject jsonObject = elements.getJSONObject(x);
                            String index          = jsonObject.getString("nama");
                            kab_id                = jsonObject.getString("id");
                            DROPDOWN_KECAMATAN.add(index);
                        }
                        edt_kec.setAdapter(new ArrayAdapter<>(UpdateProfile.this,R.layout.support_simple_spinner_dropdown_item,DROPDOWN_KABUPATEN));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                edt_kec.showDropDown();
                            }
                        },100);
                    }
                    if (status.equals("false")){
                        Toast.makeText(UpdateProfile.this, "Pesan "+data, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void  update_profile(){
        class updt extends AsyncTask<Void,Void,String>{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }
            @Override
            protected String doInBackground(Void... voids) {
                return null;
            }
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
            }
        }
        updt x = new updt();
        x.execute();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent1 = new Intent(UpdateProfile.this,Profile.class);
        startActivity(intent1);
        finish();
    }
}
