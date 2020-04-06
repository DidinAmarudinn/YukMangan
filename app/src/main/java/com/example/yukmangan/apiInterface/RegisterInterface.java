package com.example.yukmangan.apiInterface;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RegisterInterface {
    String REGISTRASI_URL = "https://yukmangan.id/api/api/";
    @FormUrlEncoded
    @POST("relawan")
     Call<String> getUserRegister(
            @Field("nama_lengkap") String name,
            @Field("email") String email,
            @Field("alamat") String alamat,
            @Field("password") String password
    ) ;


}
