package com.example.teocalli.login;

import com.example.teocalli.shared.entities.User;

public interface    LoginActivityMVP {

    interface Model {
        void createUser(String userName, String password);
        User getUser();
    }
    interface View {
        String getUserName();
        String getPassword();

        void showUserNotAvailable();
        void showInputError();
        void showUserLoggedIn();

        void setUserName(String userName);
        void setPassword(String password);
    }
    interface Presenter {
        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();
    }
}
