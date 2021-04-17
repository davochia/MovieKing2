package com.wisekingdavid.movieking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wisekingdavid.movieking.DataService.MovieDataService;
import com.wisekingdavid.movieking.adapter.RecycleViewMovieAdapter;
import com.wisekingdavid.movieking.model.AbstractActivity;
import com.wisekingdavid.movieking.model.Movie;

import java.util.List;

public class PopularMoviesActivity extends AbstractActivity {


    @Override
    protected int getLayout() {
        return R.layout.activity_popular_movies;
    }

    @Override
    protected void initLayout() {
        final MovieDataService movieDataService = new MovieDataService(PopularMoviesActivity.this);


        // Navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.popularButton);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nowPlayingButton:
                        startActivity(new Intent(getApplicationContext(), NowPlayingActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.popularButton:
//                        startActivity(new Intent(getApplicationContext(), PopularMoviesActivity.class));
//                        overridePendingTransition(0,0);
                        return true;

                    case R.id.searchButton:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


        movieDataService.getPopularMovies(new MovieDataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(PopularMoviesActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(List<Movie> popularMoviesList) {

                RecyclerView myRecycler = findViewById(R.id.popularMainRecycler);

                RecycleViewMovieAdapter myMovieAdapter = new RecycleViewMovieAdapter(PopularMoviesActivity.this, popularMoviesList);
                myRecycler.setLayoutManager(new GridLayoutManager(PopularMoviesActivity.this, 2));
                myRecycler.setAdapter(myMovieAdapter);


                //Toast.makeText(PopularMoviesActivity.this, popularMoviesList.toString(), Toast.LENGTH_SHORT).show();

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