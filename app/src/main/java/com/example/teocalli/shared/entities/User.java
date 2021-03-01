package com.example.teocalli.shared.entities;

import java.util.List;

import com.example.teocalli.shared.entities.http.request200.UserRole;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("CreatedAt")
    @Expose
    private String createdAt;
    @SerializedName("UpdatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("DeletedAt")
    @Expose
    private Object deletedAt;
    @SerializedName("UUID")
    @Expose
    private String uUID;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("father_surname")
    @Expose
    private String fatherSurname;
    @SerializedName("mother_surname")
    @Expose
    private String motherSurname;
    @SerializedName("Password")
    @Expose
    private String password;
    @SerializedName("IsVerified")
    @Expose
    private Boolean isVerified;
    @SerializedName("user_role_id")
    @Expose
    private Integer userRoleId;
    @SerializedName("UserRole")
    @Expose
    private UserRole userRole;
    @SerializedName("Documents")
    @Expose
    private List<Object> documents = null;
    @SerializedName("Accommodations")
    @Expose
    private List<Object> accommodations = null;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getUUID() {
        return uUID;
    }

    public void setUUID(String uUID) {
        this.uUID = uUID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherSurname() {
        return fatherSurname;
    }

    public void setFatherSurname(String fatherSurname) {
        this.fatherSurname = fatherSurname;
    }

    public String getMotherSurname() {
        return motherSurname;
    }

    public void setMotherSurname(String motherSurname) {
        this.motherSurname = motherSurname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<Object> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Object> documents) {
        this.documents = documents;
    }

    public List<Object> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(List<Object> accommodations) {
        this.accommodations = accommodations;
    }

}