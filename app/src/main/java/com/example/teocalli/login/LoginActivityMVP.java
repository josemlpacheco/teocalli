package com.example.teocalli.login;

import com.example.teocalli.shared.entities.User;

public interface LoginActivityMVP {

    interface Model {
        String loginUser(String userName, String password);
    }
    interface View {
        String getUserName();
        String getPassword();

        void showUserNotAvailable();
        void showInputError();
        void showUserLoggedIn(String message);
    }
    interface Presenter {
        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
    }
}
