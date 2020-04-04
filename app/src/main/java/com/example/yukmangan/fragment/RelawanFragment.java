package com.example.yukmangan.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yukmangan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RelawanFragment extends Fragment {

    public RelawanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_relawan, container, false);
    }
}
