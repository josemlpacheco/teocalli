package com.example.teocalli.login;

import androidx.annotation.Nullable;

import com.example.teocalli.shared.entities.User;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter{

    @Nullable
    private LoginActivityMVP.View view;
    private  LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {

        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null) {
            if (view.getUserName().trim().equals("") || view.getPassword().trim().equals("")) {
                view.showInputError();
            } else {
                model.createUser(view.getUserName().trim(),view.getPassword().trim());
                view.showUserLoggedIn();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if (user == null) {
            if (view != null) {
                view.showUserNotAvailable();
            }
        } else {
            view.setUserName(user.getUserName());
            view.setPassword(user.getPassword());
        }
    }
}
