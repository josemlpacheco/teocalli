package com.example.teocalli.signup;

import com.example.teocalli.shared.entities.ApiResponse;
import com.example.teocalli.shared.entities.User;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface TeocalliAPI {

    @POST("/api/v1/auth/account")
    Call<ApiResponse> signUpUser(@Body User user);
}
