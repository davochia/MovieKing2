package com.wisekingdavid.movieking;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wisekingdavid.movieking.DataService.MovieDataService;
import com.wisekingdavid.movieking.adapter.RecycleViewMovieAdapter;
import com.wisekingdavid.movieking.model.AbstractActivity;
import com.wisekingdavid.movieking.model.Movie;

import java.util.List;

public class SearchActivity extends AbstractActivity implements SearchView.OnQueryTextListener {
    SearchView searchText;
    final MovieDataService movieDataService = new MovieDataService(SearchActivity.this);

    @Override
    protected int getLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initLayout() {
        searchText = findViewById(R.id.edxSearch);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.searchButton);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nowPlayingButton:
                        startActivity(new Intent(getApplicationContext(), NowPlayingActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.popularButton:
                        startActivity(new Intent(getApplicationContext(), PopularMoviesActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.searchButton:
//                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
//                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        searchText = findViewById(R.id.edxSearch);
        searchText.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        movieDataService.getSearchMovies(newText.trim(), new MovieDataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(SearchActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(List<Movie> searchMovies) {
                //Toast.makeText(SearchActivity.this, searchMovies.toString(), Toast.LENGTH_SHORT).show();

                RecyclerView myRecycler = findViewById(R.id.searchRecycleView);

                RecycleViewMovieAdapter myMovieAdapter = new RecycleViewMovieAdapter(SearchActivity.this, searchMovies);
                myRecycler.setLayoutManager(new GridLayoutManager(SearchActivity.this, 2));
                myRecycler.setAdapter(myMovieAdapter);


            }
        });
        return false;
    }


    @Override
    public boolean onQueryTextSubmit(String query) {

//        movieDataService.getSearchMovies(query, new MovieDataService.VolleyResponseListener() {
//            @Override
//            public void onError(String message) {
//                Toast.makeText(SearchActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
//            }
//            @Override
//            public void onResponse(List<Movie> searchMovies) {
//
//                if(searchMovies.isEmpty()){
//                    Toast.makeText(SearchActivity.this, "No result found!", Toast.LENGTH_SHORT).show();
//
//                }
//
//                Toast.makeText(SearchActivity.this, searchMovies.toString(), Toast.LENGTH_SHORT).show();
////                RecyclerView myRecycler = findViewById(R.id.searchRecycleView);
////
////                RecycleViewMovieAdapter myMovieAdapter = new RecycleViewMovieAdapter(SearchActivity.this, searchMovies);
////                myRecycler.setLayoutManager(new GridLayoutManager(SearchActivity.this, 2));
////                myRecycler.setAdapter(myMovieAdapter);
//
//
//            }
//        });
        return true;
    }


    @Override
    protected void runOperations() {

    }

    @Override
    protected void stopOperations() {

    }



}