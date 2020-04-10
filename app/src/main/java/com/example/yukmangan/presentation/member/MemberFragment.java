package com.example.yukmangan.presentation.member;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yukmangan.R;
import com.example.yukmangan.api.RequestHandler;
import com.example.yukmangan.api.WebServiceApi;
import com.example.yukmangan.helper.PreferenceHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MemberFragment extends Fragment {
    TextView tv_relawan_saldo_dashboard;
    private PreferenceHelper preferenceHelper;
    public MemberFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_member, container, false);
        preferenceHelper=new PreferenceHelper(getContext());
        TextView tv_member_dashboard=view.findViewById(R.id.tv_nama_member_dashbooard);
        TextView tv_relawan_saldo_dashboard = view.findViewById(R.id.tv_alamat_relawan_dashboard);
        total_saldo();
        return view;
    }

    void total_saldo(){
        class saldo extends AsyncTask<Void,Void,String>{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Log.d("","Loading.....");
            }

            @Override
            protected String doInBackground(Void... voids) {
                return new RequestHandler().sendGetRequest(WebServiceApi.URL_SALDO);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                get_json_saldo(s);
            }
        }
        saldo x = new saldo();
        x.execute();
    }

    void get_json_saldo(String json){
        try {
            JSONObject object = new JSONObject(json);
            String status     = object.getString("status");
            String data       = object.getString("data");
            if (status.equals("true")){

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
