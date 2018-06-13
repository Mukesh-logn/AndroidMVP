package com.my.mvppractice.mvp.mvp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.my.mvppractice.R;
import com.my.mvppractice.mvp.mvp.responsemodel.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by M1030452 on 3/21/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    private List<Movie> movies;
    private int rowLayout;
    private Context context;
    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.rating.setText(movies.get(position).getVote_average());

        Picasso.with(context).load("https://image.tmdb.org/t/p/w300_and_h450_bestv2" + movies.get(position)
                .getPoster_path()).
                into(holder.movie_thumbnail);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        Button bookShowButton;
        TextView rating;
        ImageView movie_thumbnail;

        public MovieViewHolder(View rootView) {
            super(rootView);
            moviesLayout = (LinearLayout) rootView.findViewById(R.id.movie_layout);
            movieTitle = (TextView) rootView.findViewById(R.id.movie_title);
            bookShowButton = (Button) rootView.findViewById(R.id.book_show_button);
            rating = (TextView) rootView.findViewById(R.id.rating);
            movie_thumbnail = (ImageView) rootView.findViewById(R.id.movie_thumbnail);
        }

    }

}
