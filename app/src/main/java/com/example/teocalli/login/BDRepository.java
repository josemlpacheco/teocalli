package com.example.teocalli.login;

import com.example.teocalli.shared.entities.http.request200.ApiResponse;

import java.io.IOException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BDRepository implements LoginRepository {
    String message = "";
    @Override
    public String login(String username, String password) {

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://afternoon-reaches-14063.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TeocalliAPI teocalliAPI = retrofit.create(TeocalliAPI.class);

        Call<ApiResponse> call = teocalliAPI.loginUser(username,password);

        call.enqueue(new Callback<ApiResponse>() {

            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                try {
                    if (response.code() == 201) {
                        message = "welcome";

                    } else {
                        String bodyRaw = response.errorBody().string();
                        bodyRaw = bodyRaw.substring(bodyRaw.lastIndexOf("message"),bodyRaw.indexOf("data"));
                        System.out.println(bodyRaw);
                        message = bodyRaw;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                System.out.println("OnFailure-----> " + t.getMessage());
                message = t.getMessage();

            }
        });
        return message;
    }
}
