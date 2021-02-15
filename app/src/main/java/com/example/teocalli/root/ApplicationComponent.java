package com.example.teocalli.root;

import android.app.Application;

import com.example.teocalli.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity target);
}
