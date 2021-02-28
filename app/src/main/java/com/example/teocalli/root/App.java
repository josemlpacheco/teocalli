package com.example.teocalli.root;

import android.app.Application;

import com.example.teocalli.login.LoginModule;
import com.example.teocalli.shared.retrofit.RetrofitService;
import com.example.teocalli.signup.SignUpModule;

public class App extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component =DaggerApplicationComponent.builder()
                .loginModule(new LoginModule())
                .signUpModule(new SignUpModule())
                .retrofitService(new RetrofitService())
                .applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }

}
