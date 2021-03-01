package com.example.teocalli.signup;

public class SignUpValidation {
    private boolean name;
    private boolean lastName;
    private boolean email;
    private boolean password;

    public boolean isValid() {
        return name && lastName && email && password;
    }

    public boolean isName() {
        return name;
    }

    public void setName(boolean name) {
        this.name = name;
    }

    public boolean isLastName() {
        return lastName;
    }

    public void setLastName(boolean lastName) {
        this.lastName = lastName;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isPassword() {
        return password;
    }

    public void setPassword(boolean password) {
        this.password = password;
    }
}
