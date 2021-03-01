package com.example.teocalli.shared.retrofit;

import com.example.teocalli.signup.TeocalliAPI;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService<T> {
    private final String BASE_URL = "https://afternoon-reaches-14063.herokuapp.com";

    public T provideApiService(Class<T> type) {
        return provideRetrofit(BASE_URL, provideHttpClient()).create(type);
    }

    private OkHttpClient provideHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    private Retrofit provideRetrofit(String url, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
