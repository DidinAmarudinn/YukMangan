package com.example.yukmangan.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BeritaModel {

    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("id_kategori")
    @Expose
    private String idKategori;
    @SerializedName("id_tags")
    @Expose
    private String idTags;
    @SerializedName("judul_artikel")
    @Expose
    private String judulArtikel;
    @SerializedName("isi_artikel")
    @Expose
    private String isiArtikel;
    @SerializedName("tgl_publish")
    @Expose
    private String tglPublish;
    @SerializedName("tampil")
    @Expose
    private String tampil;
    @SerializedName("filefoto")
    @Expose
    private String filefoto;
    @SerializedName("meta_title")
    @Expose
    private String metaTitle;
    @SerializedName("meta_description")
    @Expose
    private String metaDescription;
    @SerializedName("keyword")
    @Expose
    private String keyword;
    @SerializedName("focus_keyword")
    @Expose
    private String focusKeyword;
    @SerializedName("view")
    @Expose
    private String view;
    @SerializedName("id_artikel")
    @Expose
    private String idArtikel;
    @SerializedName("nama")
    @Expose
    private Object nama;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("komentar")
    @Expose
    private Object komentar;
    @SerializedName("tanggal")
    @Expose
    private Object tanggal;
    @SerializedName("jam")
    @Expose
    private Object jam;
    @SerializedName("status")
    @Expose
    private Object status;
    @SerializedName("total")
    @Expose
    private String total;

    public BeritaModel(Object id, String idKategori, String idTags, String judulArtikel, String isiArtikel, String tglPublish, String tampil, String filefoto, String metaTitle, String metaDescription, String keyword, String focusKeyword, String view, String idArtikel, Object nama, Object email, Object komentar, Object tanggal, Object jam, Object status, String total) {
        this.id = id;
        this.idKategori = idKategori;
        this.idTags = idTags;
        this.judulArtikel = judulArtikel;
        this.isiArtikel = isiArtikel;
        this.tglPublish = tglPublish;
        this.tampil = tampil;
        this.filefoto = filefoto;
        this.metaTitle = metaTitle;
        this.metaDescription = metaDescription;
        this.keyword = keyword;
        this.focusKeyword = focusKeyword;
        this.view = view;
        this.idArtikel = idArtikel;
        this.nama = nama;
        this.email = email;
        this.komentar = komentar;
        this.tanggal = tanggal;
        this.jam = jam;
        this.status = status;
        this.total = total;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
    }

    public String getIdTags() {
        return idTags;
    }

    public void setIdTags(String idTags) {
        this.idTags = idTags;
    }

    public String getJudulArtikel() {
        return judulArtikel;
    }

    public void setJudulArtikel(String judulArtikel) {
        this.judulArtikel = judulArtikel;
    }

    public String getIsiArtikel() {
        return isiArtikel;
    }

    public void setIsiArtikel(String isiArtikel) {
        this.isiArtikel = isiArtikel;
    }

    public String getTglPublish() {
        return tglPublish;
    }

    public void setTglPublish(String tglPublish) {
        this.tglPublish = tglPublish;
    }

    public String getTampil() {
        return tampil;
    }

    public void setTampil(String tampil) {
        this.tampil = tampil;
    }

    public String getFilefoto() {
        return filefoto;
    }

    public void setFilefoto(String filefoto) {
        this.filefoto = filefoto;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getFocusKeyword() {
        return focusKeyword;
    }

    public void setFocusKeyword(String focusKeyword) {
        this.focusKeyword = focusKeyword;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getIdArtikel() {
        return idArtikel;
    }

    public void setIdArtikel(String idArtikel) {
        this.idArtikel = idArtikel;
    }

    public Object getNama() {
        return nama;
    }

    public void setNama(Object nama) {
        this.nama = nama;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }
    public Object getKomentar() {
        return komentar;
    }
    public void setKomentar(Object komentar) {
        this.komentar = komentar;
    }
    public Object getTanggal() {
        return tanggal;
    }
    public void setTanggal(Object tanggal) {
        this.tanggal = tanggal;
    }
    public Object getJam() {
        return jam;
    }
    public void setJam(Object jam) {
        this.jam = jam;
    }
    public Object getStatus() {
        return status;
    }
    public void setStatus(Object status) {
        this.status = status;
    }
    public String getTotal() {
        return total;
    }
    public void setTotal(String total) {
        this.total = total;
    }
}
