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
import com.example.yukmangan.helper.PreferenceHelper;

import org.json.JSONException;
import org.json.JSONObject;

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

        return view;
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
