package com.example.teocalli.signup;

import com.example.teocalli.shared.entities.User;

/**
 * SignUpPresenter es la implementación de la interfaz presenter de SignupMVP
 * @author GerardCod
 * @version 1.0.0
 */
public class SignUpPresenter implements SignupMVP.Presenter {
    private SignupMVP.Interactor interactor;
    private SignupMVP.View view;


    /**
     * Procesa la petición de registro proveniente de la view
     * @param user objeto de tipo User para realizar el registro en la API.
     */
    @Override
    public void signUp(User user) {

    }

    /**
     * Muestra un mensaje de resultado en la vista.
     * @param message Mensaje de respuesta de la petición de registro.
     */
    @Override
    public void showResult(String message) {
        this.view.showResult(message);
    }

    @Override
    public void setView(SignupMVP.View view) {
        this.view = view;
    }
}
