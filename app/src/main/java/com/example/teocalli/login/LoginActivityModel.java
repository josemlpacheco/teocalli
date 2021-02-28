package com.example.teocalli.login;

public class LoginActivityModel implements LoginActivityMVP.Model {

    private LoginRepository repository;
    BDRepository bdRepository;

    public LoginActivityModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void loginUser(String userName, String password) {
        repository.login(userName,password);
    }
}
