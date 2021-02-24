package com.example.teocalli.login;

import com.example.teocalli.shared.entities.User;

public class LoginActivityModel implements LoginActivityMVP.Model {

    private LoginRepository repository;

    public LoginActivityModel(LoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(String userName, String password) {
        repository.saveUSer(new User(userName,password));
    }

    @Override
    public User getUser() {
        return repository.getUser();
    }
}
