package com.my.mvppractice.mvp.restclient;

import com.my.mvppractice.mvp.mvp.responsemodel.MovieResponse;
import com.my.mvppractice.mvp.mvp.responsemodel.MovieResponseByID;
import com.my.mvppractice.mvp.restclient.request.RequestGetNowShowingMovieRecord;
import com.my.mvppractice.mvp.restclient.requestmodel.APIKeyRequestModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by M1030452 on 3/21/2017 for personal use.
 */

public interface ApiInterface {
    /* POST GET PUT DELETE*/
    @POST("top_rated")
    Call<MovieResponse> getTopRatedMovies(@Body APIKeyRequestModel body);

    @POST("{id}/videos")
    Call<MovieResponseByID> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("now_playing")
    Call<MovieResponse> getNowPlayingMovies(@Query("api_key") String apiKey);

    @POST("upcoming")
    Call<MovieResponse> getUpcomingMovie(@Query("api_key") String apiKey);

}
