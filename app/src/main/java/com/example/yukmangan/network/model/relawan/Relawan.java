package com.example.yukmangan.network.model.relawan;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Relawan {

    @Expose
    private List<Datum> data;
    @Expose
    private String status;

    public Relawan(){
        this.data = data;
        this.status = status;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}