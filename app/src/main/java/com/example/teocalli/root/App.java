package com.example.teocalli.root;

import android.app.Application;

import com.example.teocalli.login.LoginModule;
import com.example.teocalli.shared.retrofit.RetrofitService;

public class App extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component =DaggerApplicationComponent.builder()
                .loginModule(new LoginModule())
                .applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }

}
