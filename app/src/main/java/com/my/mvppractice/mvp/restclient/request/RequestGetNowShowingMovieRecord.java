package com.my.mvppractice.mvp.restclient.request;

import android.util.Log;

import com.google.gson.Gson;
import com.my.mvppractice.mvp.mvp.responsemodel.MovieResponse;
import com.my.mvppractice.mvp.restclient.ApiClient;
import com.my.mvppractice.mvp.restclient.ApiInterface;
import com.my.mvppractice.mvp.restclient.requestmodel.APIKeyRequestModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by M1030452 on 8/15/2017 for personal use.
 */

public class RequestGetNowShowingMovieRecord<T> {

    private final ApiClient.OnDataReceived mCallBack;
    ApiInterface mClient;
    ApiClient mService;
    private APIKeyRequestModel mRequestObject;

    public RequestGetNowShowingMovieRecord(APIKeyRequestModel mRequestObject, ApiClient.OnDataReceived<T>
            callback) {
        mClient = ApiClient.getClient();
        mService = new ApiClient();
        this.mRequestObject = mRequestObject;
        mCallBack = callback;
    }


    public void callService() {
        Call<MovieResponse> call =
                mClient.getNowPlayingMovies(mRequestObject.getApi_key());

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call,
                                   Response<MovieResponse> response) {


                Log.d("reqAddBathroom", new Gson().toJson(mRequestObject));
                Log.d("resAddBathRoom", new Gson().toJson(response));

                mService.onResponse(response, mCallBack);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                mCallBack.onDataFailure(t.getMessage());
            }
        });
    }
}
