package com.example.teocalli.login;

public class LoginActivityModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginActivityModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public String loginUser(String userName, String password) {
        return repository.login(userName,password);
    }


}
