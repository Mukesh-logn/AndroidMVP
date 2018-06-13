package com.my.mvppractice.mvp.mvp;

import com.my.mvppractice.mvp.mvp.responsemodel.MovieResponse;

/**
 * Created by M1030452 on 8/14/2017.
 */

public class PresenterImpl implements IPresenter, IModel.OnServiceFinishedListener {
    private IView mView;
    private IModel mModel;

    public PresenterImpl(IView mView) {
        this.mView = mView;
        this.mModel = new ModelImpl();
    }


    @Override
    public void getMovieRecord(String apiKey) {
        mModel.getMovieRecord(apiKey, this);

    }

    @Override
    public void getTopRatedMovies(String apiKey) {
        mModel.getTopRatedMovies(apiKey, this);
    }

    @Override
    public void getMovieDetailsById(int id, String apiKey) {
        mModel.getMovieDetailsById(id, apiKey, this);
    }

    @Override
    public void getUpcomingMovie(String apiKey) {
        mModel.getUpcomingMovie(apiKey, this);

    }

    @Override
    public void onSuccess(MovieResponse movieResponse) {
        mView.setNowShowingMovieRecord(movieResponse);
    }

    @Override
    public void onFailure(String error) {

    }
}
