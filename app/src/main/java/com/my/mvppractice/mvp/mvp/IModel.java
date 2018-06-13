package com.my.mvppractice.mvp.mvp;

import com.my.mvppractice.mvp.mvp.responsemodel.MovieResponse;

/**
 * Created by M1030452 on 8/14/2017.
 */

public interface IModel {
    public interface OnServiceFinishedListener {
        void onSuccess(MovieResponse object);
        void onFailure(String error);
    }
    void getMovieRecord(String apiKey,OnServiceFinishedListener listener);

    void getTopRatedMovies(String apiKey,OnServiceFinishedListener listener);

    void getMovieDetailsById(int id,String apiKey,OnServiceFinishedListener listener);

    void getUpcomingMovie(String apiKey,OnServiceFinishedListener listener);
}
