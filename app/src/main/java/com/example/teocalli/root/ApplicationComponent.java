package com.example.teocalli.root;

import com.example.teocalli.login.LoginActivity;
import com.example.teocalli.login.LoginModule;
import com.example.teocalli.shared.retrofit.RetrofitService;
import com.example.teocalli.signup.SignUpModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class, SignUpModule.class, RetrofitService.class})
public interface ApplicationComponent {
    void inject(LoginActivity target);
}
