package com.example.teocalli.root;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teocalli.login.LoginActivity;
import com.example.teocalli.login.LoginModule;
import com.example.teocalli.shared.retrofit.RetrofitService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {
    void inject(AppCompatActivity target);
}
