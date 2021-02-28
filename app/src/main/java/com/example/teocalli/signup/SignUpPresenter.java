package com.example.teocalli.signup;

import com.example.teocalli.shared.entities.User;

/**
 * SignUpPresenter es la implementación de la interfaz presenter de SignupMVP
 * @author GerardCod
 * @version 1.0.0
 */
public class SignUpPresenter implements SignupMVP.Presenter {
    private SignupMVP.View view;
    private SignupMVP.Interactor interactor;

    public SignUpPresenter(SignupMVP.View view) {
        this.view = view;
        this.interactor = new SignUpInteractor(this);
    }

    /**
     * Procesa la petición de registro proveniente de la view
     * @param user objeto de tipo User para realizar el registro en la API.
     */
    @Override
    public void signUp(User user) {
        this.interactor.signUp(user);
    }

    /**
     * Muestra un mensaje de resultado en la vista.
     * @param message Mensaje de respuesta de la petición de registro.
     */
    @Override
    public void showResult(String message) {
        this.view.showResult(message);
    }

}
