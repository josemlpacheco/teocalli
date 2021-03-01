package com.example.teocalli.signup;

import com.example.teocalli.shared.entities.User;

/**
 * SignUpRepository es una interfaz que define los comportamientos de la pantalla de registro.
 */
public interface SignUpRepository {
    void signupUser(User user);
    void setPresenter(SignupMVP.Presenter presenter);
}
