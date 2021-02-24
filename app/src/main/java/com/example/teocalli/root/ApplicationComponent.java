package com.example.teocalli.root;

import com.example.teocalli.login.LoginActivity;
import com.example.teocalli.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {
    void inject(LoginActivity target);
}
