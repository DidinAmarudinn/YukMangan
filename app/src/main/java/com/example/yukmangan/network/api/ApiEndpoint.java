package com.example.yukmangan.network.api;

import com.example.yukmangan.network.model.BeritaModel;
import com.example.yukmangan.network.model.CountRelawanModel;
import com.example.yukmangan.network.model.IndoneisaModel;
import com.example.yukmangan.network.model.kabupaten.ResponseKabupaten;
import com.example.yukmangan.network.model.provinsi.ResponseProvinsi;
import com.example.yukmangan.network.model.donatur.Donatur;
import com.example.yukmangan.network.model.relawan.Relawan;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpoint {
    @GET(Api.END_POINT_IDN)
    Call<IndoneisaModel> getSummaryIdn();


    @Multipart
    @POST(Api.END_GAMBAR_VALIDASI)
    Call<RequestBody> uploadGambar(@Part MultipartBody.Part body);


    @GET(Api.END_PROVINSI)
    Call<ResponseProvinsi> getProvinsi();

    @GET(Api.END_KABUPATEN_BY_ID)
    Call<ResponseKabupaten> getKabupaten(@Query("provinsi_id") String provinsi_id);

    @GET(Api.END_RELAWAN_BY_ID)
    Call<Relawan> getDataRelawanById(
            @Query("id") String id_relawan
    );

    @GET(Api.GET_DONATUR)
    Call<Donatur> getDataDonatur();

    @GET(Api.END_COUNT_RELAWAN)
    Call<ResponseBody> getCountRelawan();

    @GET(Api.END_BERITA)
    Call<List<BeritaModel>> getListBerita();

    @GET(Api.END_COUNT_RELAWAN)
    Call<CountRelawanModel> getCount();

    @GET(Api.END_GET_COUNT_RW)
    Call<ResponseBody> getCountRw();

    @FormUrlEncoded
    @POST(Api.END_LOGIN)
    Call<ResponseBody> getUserLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST(Api.END_REGISTER)
    Call<ResponseBody> getUserRegister(
            @Field("nama_lengkap") String name,
            @Field("email") String email,
            @Field("alamat") String alamat,
            @Field("password") String password,
            @Field("id_provinsi") String id_provinsi,
            @Field("id_kabupaten") String id_kabupaten,
            @Field("id_kecamatan") String id_kecamatan,
            @Field("id_desa") String id_desa,
            @Field("id_pekerjaan") String id_pekerjaan,
            @Field("id_jabatan") String id_jabatan,
            @Field("id_pendaftar_skill") String id_pendaftar_skill,
            @Field("no_wa") String no_wa,
            @Field("rw") String rw,
            @Field("rt") String rt,
            @Field("no_ktp") String no_ktp,
            @Field("tempat_lahir") String tempat_lahir,
            @Field("tgl_lahir") String tgl_lahir,
            @Field("jk") String jk,
            @Field("siap_relawan") String siap_relawan,
            @Field("tgl_daftar") String tgl_daftar


    ) ;

}
