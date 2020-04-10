package com.example.yukmangan.presentation.relawan;

import com.example.yukmangan.network.model.relawan.Relawan;

public interface RelawanView {

    void getDataRelawanById(Relawan relawan);
    void onFailure(Throwable error);


}
