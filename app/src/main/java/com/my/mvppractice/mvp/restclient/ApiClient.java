package com.my.mvppractice.mvp.restclient;

import com.my.mvppractice.mvp.util.AppConstant;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by M1030452 on 3/21/2017.
 */

public class ApiClient {
    private static ApiInterface mClient;
    private static final String SUCCESS_CODE = "200";
    private static Retrofit retrofit = null;

    public interface OnDataReceived<T> {
        void onDataSuccess(T object);

        void onDataFailure(String error);
    }

    public static ApiInterface getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mClient = retrofit.create(ApiInterface.class);
    }

    public <T extends RetroBaseResponse> void onResponse(retrofit2.Response<T> response,
                                                         OnDataReceived callBack) {
        String errMessage = "Unknown error";
        T result = null;
        if (response.isSuccessful()) {
            if (response.body() != null) {
                result = response.body();
            } else {
                errMessage = "Parser error";
            }
        } else {
            try {
                errMessage = response.errorBody().string();
            } catch (IOException e) {
                e.printStackTrace();
                errMessage = e.getMessage();
            }
        }

        if (result == null) {
            callBack.onDataFailure(errMessage);
        } else {
            callBack.onDataSuccess(result);

        }

    }
}
