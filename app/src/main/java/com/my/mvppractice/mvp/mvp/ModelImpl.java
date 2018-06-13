package com.my.mvppractice.mvp.mvp;

import com.my.mvppractice.mvp.mvp.responsemodel.MovieResponse;
import com.my.mvppractice.mvp.restclient.ApiClient;
import com.my.mvppractice.mvp.restclient.request.RequestGetNowShowingMovieRecord;
import com.my.mvppractice.mvp.restclient.requestmodel.APIKeyRequestModel;

/**
 * Created by M1030452 on 8/14/2017.
 */

public class ModelImpl implements IModel {
    @Override
    public void getMovieRecord(String apiKey, final OnServiceFinishedListener listener) {
        APIKeyRequestModel apiKeyRequestModel = new APIKeyRequestModel(apiKey);
        new RequestGetNowShowingMovieRecord<>(apiKeyRequestModel, new ApiClient.OnDataReceived<MovieResponse>() {
            @Override
            public void onDataSuccess(MovieResponse movieResponse) {
                listener.onSuccess(movieResponse);
            }

            @Override
            public void onDataFailure(String error) {

            }
        }).callService();

    }

    @Override
    public void getTopRatedMovies(String apiKey, OnServiceFinishedListener listener) {

    }

    @Override
    public void getMovieDetailsById(int id, String apiKey, OnServiceFinishedListener listener) {

    }

    @Override
    public void getUpcomingMovie(String apiKey, OnServiceFinishedListener listener) {

    }
}
