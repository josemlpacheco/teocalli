package com.example.teocalli.login;

import com.example.teocalli.shared.entities.http.request200.ApiResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TeocalliAPI {

    @FormUrlEncoded
    @POST("api/v1/auth")
    Call<ApiResponse> loginUser(@Body @Field("username") String userName, @Field("password") String password);
}
