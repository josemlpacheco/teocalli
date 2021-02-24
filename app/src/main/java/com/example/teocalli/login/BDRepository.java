package com.example.teocalli.login;

import com.example.teocalli.shared.entities.User;

public class BDRepository implements LoginRepository{

    private User user;

    @Override
    public void saveUSer(User user) {
        if(user == null) {
            user = getUser();
        }
        this.user = user;
    }

    @Override
    public User getUser() {
        if(user == null) {
            user = new User("memo@gmail.com","Amemolegustaelpan.");
            return user;
        }else {
            return user;
        }
    }
}
