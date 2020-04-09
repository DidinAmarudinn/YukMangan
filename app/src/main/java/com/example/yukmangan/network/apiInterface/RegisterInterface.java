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
            @Field("password") String password

    ) ;

}
