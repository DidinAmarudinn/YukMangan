
package com.example.yukmangan.network.model.relawan;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Datum {

    @Expose
    private String alamat;
    @Expose
    private String email;
    @Expose
    private String id;
    @SerializedName("id_desa")
    private String idDesa;
    @SerializedName("id_jabatan")
    private String idJabatan;
    @SerializedName("id_kabupaten")
    private String idKabupaten;
    @SerializedName("id_kecamatan")
    private String idKecamatan;
    @SerializedName("id_pekerjaan")
    private String idPekerjaan;
    @SerializedName("id_pendaftar_skill")
    private String idPendaftarSkill;
    @SerializedName("id_provinsi")
    private String idProvinsi;
    @Expose
    private String jk;
    @SerializedName("nama_lengkap")
    private String namaLengkap;
    @SerializedName("no_ktp")
    private String noKtp;
    @SerializedName("no_wa")
    private String noWa;
    @Expose
    private String password;
    @Expose
    private String rt;
    @Expose
    private String rw;
    @SerializedName("siap_relawan")
    private String siapRelawan;
    @SerializedName("tempat_lahir")
    private String tempatLahir;
    @SerializedName("tgl_daftar")
    private String tglDaftar;
    @SerializedName("tgl_lahir")
    private String tglLahir;

    public Datum(){
        this.alamat = alamat;
        this.email  = email;
        this.id = id;
        this.idDesa = idDesa;
        this.idJabatan = idJabatan;
        this.idKabupaten = idKabupaten;
        this.alamat = alamat;
        this.idKecamatan = idKecamatan;
        this.idPekerjaan = idPekerjaan;
        this.idPendaftarSkill = idPendaftarSkill;
        this.idProvinsi = idProvinsi;
        this.jk = jk;
        this.namaLengkap = namaLengkap;
        this.noKtp = noKtp;
        this.noWa = noWa;
        this.password = password;
        this.rt = rt;
        this.rw = rw;
        this.siapRelawan = siapRelawan;
        this.tempatLahir = tempatLahir;
        this.tglDaftar = tglDaftar;
        this.tglLahir = tglDaftar;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdDesa() {
        return idDesa;
    }

    public void setIdDesa(String idDesa) {
        this.idDesa = idDesa;
    }

    public String getIdJabatan() {
        return idJabatan;
    }

    public void setIdJabatan(String idJabatan) {
        this.idJabatan = idJabatan;
    }

    public String getIdKabupaten() {
        return idKabupaten;
    }

    public void setIdKabupaten(String idKabupaten) {
        this.idKabupaten = idKabupaten;
    }

    public String getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(String idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getIdPekerjaan() {
        return idPekerjaan;
    }

    public void setIdPekerjaan(String idPekerjaan) {
        this.idPekerjaan = idPekerjaan;
    }

    public String getIdPendaftarSkill() {
        return idPendaftarSkill;
    }

    public void setIdPendaftarSkill(String idPendaftarSkill) {
        this.idPendaftarSkill = idPendaftarSkill;
    }

    public String getIdProvinsi() {
        return idProvinsi;
    }

    public void setIdProvinsi(String idProvinsi) {
        this.idProvinsi = idProvinsi;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getNoKtp() {
        return noKtp;
    }

    public void setNoKtp(String noKtp) {
        this.noKtp = noKtp;
    }

    public String getNoWa() {
        return noWa;
    }

    public void setNoWa(String noWa) {
        this.noWa = noWa;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }

    public String getSiapRelawan() {
        return siapRelawan;
    }

    public void setSiapRelawan(String siapRelawan) {
        this.siapRelawan = siapRelawan;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTglDaftar() {
        return tglDaftar;
    }

    public void setTglDaftar(String tglDaftar) {
        this.tglDaftar = tglDaftar;
    }

    public String getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }

}
