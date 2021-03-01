package com.example.teocalli.login;

import com.example.teocalli.shared.entities.User;

public interface LoginRepository {

    void saveUSer(User user);
    User getUser();
}
