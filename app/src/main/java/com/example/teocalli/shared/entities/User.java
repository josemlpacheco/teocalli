package com.example.teocalli.shared.entities;

public class User {

    private String userName;
    private String user;
    private String fatherUserName;
    private String motherUserName;
    private String password;
    private int userRoleID;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String user, String fatherUserName, String motherUserName, String password, int userRoleID) {
        this.userName = userName;
        this.user = user;
        this.fatherUserName = fatherUserName;
        this.motherUserName = motherUserName;
        this.password = password;
        this.userRoleID = userRoleID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFatherUserName() {
        return fatherUserName;
    }

    public void setFatherUserName(String fatherUserName) {
        this.fatherUserName = fatherUserName;
    }

    public String getMotherUserName() {
        return motherUserName;
    }

    public void setMotherUserName(String motherUserName) {
        this.motherUserName = motherUserName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserRoleID() {
        return userRoleID;
    }

    public void setUserRoleID(int userRoleID) {
        this.userRoleID = userRoleID;
    }
}