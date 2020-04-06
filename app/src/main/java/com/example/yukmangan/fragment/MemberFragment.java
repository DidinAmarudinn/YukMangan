package com.example.yukmangan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yukmangan.R;
import com.example.yukmangan.helper.PreferenceHelper;

public class MemberFragment extends Fragment {
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

        return view;
    }
}
