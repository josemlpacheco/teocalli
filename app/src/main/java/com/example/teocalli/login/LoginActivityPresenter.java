package com.example.teocalli.login;

import androidx.annotation.Nullable;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {

        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {

        this.view = view
        ;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null) {
            if (view.getUserName().trim().equals("") || view.getPassword().trim().equals("")) {
                view.showInputError();
            } else {
                model.loginUser(view.getUserName().trim(),view.getPassword().trim());
                view.showUserLoggedIn();
            }
        }
    }
}
