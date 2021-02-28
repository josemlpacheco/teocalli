package com.example.teocalli.signup;

import android.util.Log;

import com.example.teocalli.shared.entities.ApiResponse;
import com.example.teocalli.shared.entities.User;
import com.example.teocalli.shared.retrofit.RetrofitService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * ApiSignUpRepository es la implementación de la interfaz SignUpRepository para establecer la comunicación con el API de teocalli
 * @author GerardCod
 * @version 1.0.0
 */
public class ApiSignUpRepository implements SignUpRepository {

    @Inject
    private RetrofitService<TeocalliAPI> service;

    @Override
    public void signupUser(User user) {
        service.provideApiService(TeocalliAPI.class).signUpUser(user).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()) {

                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
    }
}
