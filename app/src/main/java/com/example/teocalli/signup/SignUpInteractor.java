package com.example.teocalli.signup;

import com.example.teocalli.shared.entities.User;

/**
 * SignUpInteractor es la implementación de la interfaz Interactor de SignupMVP.
 * @author GerardCod
 * @version 1.0.0
 */
public class SignUpInteractor implements SignupMVP.Interactor {
    private SignUpRepository repository;

    public SignUpInteractor(SignUpRepository repository) {
        this.repository = repository;
    }

    @Override
    public void signUp(User user) {
        this.repository.signupUser(user);
    }
}
