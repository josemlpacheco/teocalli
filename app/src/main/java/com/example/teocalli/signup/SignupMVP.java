package com.example.teocalli.signup;

import com.example.teocalli.shared.entities.User;

/**
 * SignupMVP es una colección de interfaces que definen el Modelo - Vista - Presentador
 * de la pantalla registro
 * @author GerardCod
 * @version 1.0.0
 * */
public interface SignupMVP {
    interface Interactor {
        void signUp(User user);
    }

    interface Presenter {
        void signUp(User user);
        void showResult(String message);
        void setView(SignupMVP.View view);
    }

    interface View {
        void signUp(User user);
        void showResult(String message);
    }
}
