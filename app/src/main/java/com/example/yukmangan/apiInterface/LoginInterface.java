package com.example.yukmangan.apiInterface;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {
    String URL_LOGIN="http://yukmangan.id/api/Login_api/";
    @FormUrlEncoded
    @POST("get_login")
    Call<String> getUserLogin(
            @Field("email") String email,
            @Field("password") String password
            );

}
