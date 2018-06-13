package com.my.mvppractice.mvp.restclient.requestmodel;

/**
 * Created by M1030452 on 8/15/2017 for personal use.
 */

public class APIKeyRequestModel {
    String api_key;

    public APIKeyRequestModel(String api_key) {
        this.api_key = api_key;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }
}
