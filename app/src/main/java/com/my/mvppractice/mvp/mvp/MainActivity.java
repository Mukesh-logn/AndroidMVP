package com.my.mvppractice.mvp.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.my.mvppractice.R;
import com.my.mvppractice.mvp.mvp.responsemodel.Movie;
import com.my.mvppractice.mvp.mvp.responsemodel.MovieResponse;
import com.my.mvppractice.mvp.util.AppConstant;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IView, View.OnClickListener {
    RelativeLayout progressBar;
    RecyclerView recyclerView;
    private PresenterImpl mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (RelativeLayout) findViewById(R.id.relative_layout_wait);
        RelativeLayout reloadMovieLayout = (RelativeLayout) findViewById(R.id.error);
        reloadMovieLayout.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.movie_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPresenter = new PresenterImpl(this);
        mPresenter.getMovieRecord(AppConstant.MOVIE_DB_API_KEY_V3);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.error:
                hideErrorMessage();
               // selectedMovieOption(R.id.menu_now_playing);
                break;
        }

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void navigateOtherActivity() {

    }

    @Override
    public void showErrorMessage() {
        findViewById(R.id.error).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorMessage() {
        findViewById(R.id.error).setVisibility(View.GONE);
    }

    @Override
    public void setNowShowingMovieRecord(MovieResponse movieRecord) {
        hideProgressBar();
        recyclerView.removeAllViewsInLayout();
        final List<Movie> movies = movieRecord.getResults();
        recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_now_playing:
                showProgressBar();
                mPresenter.getMovieRecord(AppConstant.MOVIE_DB_API_KEY_V3);
                return true;
            case R.id.menu_coming_soon:
                showProgressBar();
                mPresenter.getUpcomingMovie(AppConstant.MOVIE_DB_API_KEY_V3);
                return true;
            case R.id.menu_top_rated:
                showProgressBar();
                mPresenter.getTopRatedMovies(AppConstant.MOVIE_DB_API_KEY_V3);
                return true;
            default:
                showProgressBar();
                mPresenter.getMovieRecord(AppConstant.MOVIE_DB_API_KEY_V3);
                return super.onOptionsItemSelected(item);

        }
    }

}
