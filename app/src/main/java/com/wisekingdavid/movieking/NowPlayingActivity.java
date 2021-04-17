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

public class NowPlayingActivity extends AbstractActivity {


    @Override
    protected int getLayout() {
        return R.layout.activity_now_playing;
    }

    @Override
    protected void initLayout() {
        final MovieDataService movieDataService = new MovieDataService(NowPlayingActivity.this);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nowPlayingButton);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.nowPlayingButton:
//                        startActivity(new Intent(getApplicationContext(), NowPlayingActivity.class));
//                        overridePendingTransition(0,0);
                    return true;

                case R.id.popularButton:
                    startActivity(new Intent(getApplicationContext(), PopularMoviesActivity.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.searchButton:
                    startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });



        movieDataService.getNowPlayingMovies(new MovieDataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(NowPlayingActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(List<Movie> nowPlayingMovieList) {

                RecyclerView myRecycler = findViewById(R.id.nowPlayingRecycleViewId);

                RecycleViewMovieAdapter myMovieAdapter = new RecycleViewMovieAdapter(NowPlayingActivity.this, nowPlayingMovieList);
                myRecycler.setLayoutManager(new GridLayoutManager(NowPlayingActivity.this, 2));
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