package com.example.teocalli.shared.entities.http.request500;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error500 {
    @SerializedName("data")
    @Expose
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
