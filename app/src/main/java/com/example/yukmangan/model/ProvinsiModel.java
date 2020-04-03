package com.example.yukmangan.model;

import com.google.gson.annotations.SerializedName;

public class ProvinsiModel {
    @SerializedName("attributes")
    private Attributes attributes;


    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public ProvinsiModel(Attributes attributes) {
        this.attributes = attributes;
    }
    public class Attributes{
        @SerializedName("Provinsi")
        private String Provinsi;
        @SerializedName("Kasus_Posi")
        private String Kasus_Posi;
        @SerializedName("Kasus_Meni")
        private String Kasus_Meni;
        @SerializedName("Kasus_Semb")
        private String Kasus_Semb;

        public Attributes(String provinsi, String kasus_Posi, String kasus_Meni, String kasus_Semb) {
            Provinsi = provinsi;
            Kasus_Posi = kasus_Posi;
            Kasus_Meni = kasus_Meni;
            Kasus_Semb = kasus_Semb;
        }

        public String getProvinsi() {
            return Provinsi;
        }

        public void setProvinsi(String provinsi) {
            Provinsi = provinsi;
        }

        public String getKasus_Posi() {
            return Kasus_Posi;
        }

        public void setKasus_Posi(String kasus_Posi) {
            Kasus_Posi = kasus_Posi;
        }

        public String getKasus_Meni() {
            return Kasus_Meni;
        }

        public void setKasus_Meni(String kasus_Meni) {
            Kasus_Meni = kasus_Meni;
        }

        public String getKasus_Semb() {
            return Kasus_Semb;
        }

        public void setKasus_Semb(String kasus_Semb) {
            Kasus_Semb = kasus_Semb;
        }
    }
}
