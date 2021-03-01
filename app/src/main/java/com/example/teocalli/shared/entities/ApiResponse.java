package com.example.teocalli.shared.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiResponse<T> {
    @SerializedName(value = "success")
    @Expose
    private boolean success;

    @SerializedName(value = "message")
    @Expose
    private String message;

    @SerializedName(value = "data")
    @Expose
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
