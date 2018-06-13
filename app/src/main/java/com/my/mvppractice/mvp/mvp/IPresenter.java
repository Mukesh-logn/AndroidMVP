package com.my.mvppractice.mvp.mvp;

/**
 * Created by M1030452 on 8/14/2017.
 */

public interface IPresenter {
    void getMovieRecord(String apiKey);

    void getTopRatedMovies(String apiKey);

    void getMovieDetailsById(int id,String apiKey);

    void getUpcomingMovie(String apiKey);
}
