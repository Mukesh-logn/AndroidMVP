package com.my.mvppractice.mvp.mvp;

import com.my.mvppractice.mvp.mvp.responsemodel.MovieResponse;

/**
 * Created by M1030452 on 8/14/2017.
 */

public interface IView {
    void showProgressBar();

    void hideProgressBar();

    void navigateOtherActivity();

    void showErrorMessage();

    void hideErrorMessage();

    void setNowShowingMovieRecord(MovieResponse movieRecord);

}
