package com.example.teocalli.shared.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName(value = "username")
    @Expose
    private String userName;

    @SerializedName(value = "name")
    @Expose
    private String user;

    @SerializedName(value = "father_surname")
    @Expose
    private String fatherUserName;

    @SerializedName(value = "mother_surname")
    @Expose
    private String motherUserName;

    @SerializedName(value = "password")
    @Expose
    private String password;

    @SerializedName(value = "user_role_id")
    @Expose
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