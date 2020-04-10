
package com.example.yukmangan.network.model.donatur;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Datum {

    @SerializedName("jenis_donasi")
    private String jenisDonasi;
    @SerializedName("jumlah_donasi")
    private String jumlahDonasi;
    @SerializedName("metode_donasi")
    private String metodeDonasi;
    @SerializedName("nama_lengkap")
    private String namaLengkap;
    @SerializedName("status_donasi")
    private String statusDonasi;
    @SerializedName("tanggal_donasi")
    private String tanggalDonasi;

    public String getJenisDonasi() {
        return jenisDonasi;
    }

    public void setJenisDonasi(String jenisDonasi) {
        this.jenisDonasi = jenisDonasi;
    }

    public String getJumlahDonasi() {
        return jumlahDonasi;
    }

    public void setJumlahDonasi(String jumlahDonasi) {
        this.jumlahDonasi = jumlahDonasi;
    }

    public String getMetodeDonasi() {
        return metodeDonasi;
    }

    public void setMetodeDonasi(String metodeDonasi) {
        this.metodeDonasi = metodeDonasi;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getStatusDonasi() {
        return statusDonasi;
    }

    public void setStatusDonasi(String statusDonasi) {
        this.statusDonasi = statusDonasi;
    }

    public String getTanggalDonasi() {
        return tanggalDonasi;
    }

    public void setTanggalDonasi(String tanggalDonasi) {
        this.tanggalDonasi = tanggalDonasi;
    }

}
