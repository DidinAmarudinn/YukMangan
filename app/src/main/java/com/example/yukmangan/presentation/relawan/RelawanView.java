package com.example.yukmangan.presentation.relawan;

import com.example.yukmangan.network.model.relawan.Datum;
import com.example.yukmangan.network.model.relawan.Relawan;

import java.util.List;

public interface RelawanView {

    void getDataRelawanById(Relawan relawan);
    void onFailure(Throwable error);


}
