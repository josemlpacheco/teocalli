package com.example.teocalli.signup;

import com.example.teocalli.shared.entities.ApiResponse;
import com.example.teocalli.shared.entities.User;

import retrofit2.Call;
import retrofit2.http.POST;


public interface TeocalliAPI {

    @POST("/auth/account")
    Call<ApiResponse> signUpUser(User user);
}
