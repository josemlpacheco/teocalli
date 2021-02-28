package com.example.teocalli.login;

import com.example.teocalli.shared.entities.http.request200.ApiResponse;
import com.example.teocalli.shared.entities.http.request200.Data;
import com.example.teocalli.shared.entities.http.request400.Error400;
import com.example.teocalli.shared.entities.http.request500.Error500;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BDRepository implements LoginRepository {

    TeocalliAPI teocalliAPI;

    @Override
    public void login(String username, String password) {
        final String[] message = {""};

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
                Gson gson = new GsonBuilder().create();
                ApiResponse apiResponse = response.body();
                if (response.isSuccessful()) {
                    String responseOfAPI = response.body().getMessage();
                    System.out.println("Result:--- >"+ responseOfAPI);
                } else {
                    System.out.println("--------------valio madres-------------------");
                    String error;
                    if (response.errorBody()
                            .contentType()
                            .subtype()
                            .equals("application/json")) {
                        Error400 errorRes = gson.fromJson(gson.toJson(apiResponse.getData()), Error400.class);
                        System.out.println("weeeeeeeeeey"+errorRes.getFailedField());
                    } else {
                        System.out.println("wey 2"+response.message());
                    }
                }
/*                    int codeStatus = response.code();
                    System.out.println("-------------Error---------------"+ codeStatus);
                    ApiResponse apiResponse = response.body();
                    Gson gson = new GsonBuilder().create();
                    if (response.body() != null) {
                        if (codeStatus == 201) {
                            TypeToken<Data> resTypeToken = new TypeToken<Data>() {};
                            Data data = gson.fromJson(gson.toJson(apiResponse.getData()),resTypeToken.getType());
                            System.out.println("Ok: ---------------------" + data.getAccessToken());
                        } else if (codeStatus == 400){
                            System.out.println("Error ---------------------");
                            Error400 errorRes = gson.fromJson(gson.toJson(apiResponse.getData()), Error400.class);
                            System.out.println("Error: ---------------------" + errorRes.getFailedField());
                        } else if (codeStatus == 500) {
                            System.out.println("Error ---------------------");
                            Error500 errorRes = gson.fromJson(gson.toJson(apiResponse.getData()), Error500.class);
                            System.out.println("Error: ---------------------" + errorRes.getData());
                        }
                    } else  {
                        System.out.println("---------Null------------");
                    }*/

            }
            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                System.out.println("OnFailure-----> " + t.getMessage());
            }
        });

    }
}
