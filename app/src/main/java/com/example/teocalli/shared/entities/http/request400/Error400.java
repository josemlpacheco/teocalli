package com.example.teocalli.shared.entities.http.request400;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Error400 {

    @SerializedName("failed_field")
    @Expose
    private String failedField;
    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("value")
    @Expose
    private String value;

    public String getFailedField() {
        return failedField;
    }

    public void setFailedField(String failedField) {
        this.failedField = failedField;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}