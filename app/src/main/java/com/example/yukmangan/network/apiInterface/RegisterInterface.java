package com.example.yukmangan.network.apiInterface;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RegisterInterface {
    String REGISTRASI_URL = "https://yukmangan.id/api/relawan/";
    @FormUrlEncoded
    @POST("post_relawan")
     Call<String> getUserRegister(
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
            @Field("jk") String jk



    ) ;

}
