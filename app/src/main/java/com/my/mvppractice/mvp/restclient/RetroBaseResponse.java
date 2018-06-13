package com.my.mvppractice.mvp.restclient;

/**
 * Created by M1030452 on 8/14/2017.
 */

public class RetroBaseResponse {
    private String status_code;
    private String status_message;

    public String getStatus_code() {
        return status_code;
    }

    public void setStatus_code(String status_code) {
        this.status_code = status_code;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }
}
