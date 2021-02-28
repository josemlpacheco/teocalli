package com.example.teocalli.signup;

import android.util.Log;

import com.example.teocalli.shared.entities.ApiResponse;
import com.example.teocalli.shared.entities.User;
import com.example.teocalli.shared.retrofit.RetrofitService;

import org.jetbrains.annotations.NotNull;

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
    protected RetrofitService<TeocalliAPI> service;
    private SignupMVP.Presenter presenter;

    public ApiSignUpRepository(SignupMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void signupUser(User user) {
        service.provideApiService(TeocalliAPI.class).signUpUser(user).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(@NotNull Call<ApiResponse> call, @NotNull Response<ApiResponse> response) {
                Log.println(Log.INFO, "response", response.toString());
            }

            @Override
            public void onFailure(@NotNull Call<ApiResponse> call, @NotNull Throwable t) {
                Log.println(Log.ERROR, "response", t.getMessage());
            }
        });
    }

    @Override
    public void setPresenter(SignupMVP.Presenter presenter) {
        this.presenter = presenter;
    }
}
