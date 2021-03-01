package com.example.teocalli.signup;

import android.util.Log;

import com.example.teocalli.login.LoginActivity;
import com.example.teocalli.shared.entities.ApiResponse;
import com.example.teocalli.shared.entities.User;
import com.example.teocalli.shared.retrofit.RetrofitService;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

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

    private RetrofitService<TeocalliAPI> service;
    private SignupMVP.Presenter presenter;

    public ApiSignUpRepository(SignupMVP.Presenter presenter) {
        this.presenter = presenter;
        this.service = new RetrofitService<>();
    }

    @Override
    public void signupUser(User user) {
        service.provideApiService(TeocalliAPI.class).signUpUser(user).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                try {
                    if (response.code() == 201) {
                        presenter.showResult("Tu cuenta fue creada con éxito, revisa tu correo electrónico");
                    } else {
                        String bodyRaw = response.errorBody().string();
                        bodyRaw = bodyRaw.substring(bodyRaw.lastIndexOf("\"message\":\""), bodyRaw.indexOf("\",\"data\""));
                        presenter.showResult(bodyRaw);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void setPresenter(SignupMVP.Presenter presenter) {
        this.presenter = presenter;
    }
}
