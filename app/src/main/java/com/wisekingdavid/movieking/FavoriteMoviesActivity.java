package com.wisekingdavid.movieking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wisekingdavid.movieking.DataService.MovieDataService;
import com.wisekingdavid.movieking.adapter.RecycleViewMovieAdapter;
import com.wisekingdavid.movieking.model.AbstractActivity;
import com.wisekingdavid.movieking.model.Movie;

import java.util.List;

public class FavoriteMoviesActivity extends AbstractActivity {


    @Override
    protected int getLayout() {
        return R.layout.activity_favorite_movies;
    }

    @Override
    protected void initLayout() {
        final MovieDataService movieDataService = new MovieDataService(FavoriteMoviesActivity.this);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.favoriteMoviesButton);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nowPlayingButton:
                        startActivity(new Intent(getApplicationContext(), NowPlayingActivity.class));
                        overridePendingTransition(0,0);
                    return true;


                case R.id.favoriteMoviesButton:
//                    startActivity(new Intent(getApplicationContext(), FavoriteMoviesActivity.class));
//                    overridePendingTransition(0, 0);
                    return true;


                case R.id.popularButton:
                    startActivity(new Intent(getApplicationContext(), PopularMoviesActivity.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.searchButton:
                    startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
            }
            return false;
        });


        movieDataService.getNowPlayingMovies(new MovieDataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(FavoriteMoviesActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(List<Movie> favoriteMoviesList) {

                RecyclerView myRecycler = findViewById(R.id.favoriteMovieRecycleViewId);

                RecycleViewMovieAdapter myMovieAdapter = new RecycleViewMovieAdapter(FavoriteMoviesActivity.this, favoriteMoviesList);
                myRecycler.setLayoutManager(new GridLayoutManager(FavoriteMoviesActivity.this, 2));
                myRecycler.setAdapter(myMovieAdapter);

                //Toast.makeText(NowPlayingActivity.this, popularMoviesList.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void runOperations() {

    }

    @Override
    protected void stopOperations() {

    }
}

