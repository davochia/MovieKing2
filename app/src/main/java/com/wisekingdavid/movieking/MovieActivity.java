package com.wisekingdavid.movieking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.ImageReader;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;
import com.wisekingdavid.movieking.DAO.MovieDAO;
import com.wisekingdavid.movieking.DB.MovieDatabase;
import com.wisekingdavid.movieking.model.AbstractActivity;
import com.wisekingdavid.movieking.model.Cast;
import com.wisekingdavid.movieking.model.Movie;


public class MovieActivity extends AbstractActivity {

    private TextView txtTitle, txtReleased, txtDescription, rRating;
    private ImageView posterImage;
    private CheckBox favCheckBox;

    @Override
    protected int getLayout() {
        return R.layout.activity_movie;
    }

    @Override
    protected void initLayout() {

        txtTitle = findViewById(R.id.detailsTitle);
        txtReleased = findViewById(R.id.detailsRelease);
        txtDescription = findViewById(R.id.detailsDescription);
        posterImage = findViewById(R.id.detailsImage);
        rRating = findViewById(R.id.detailsRating);
        favCheckBox = findViewById(R.id.favCheckBoxId);



        Intent intent = getIntent();
        String movieTitle = intent.getExtras().getString("Title");
        String description = intent.getExtras().getString("Description");
        String image = intent.getExtras().getString("Image");
        String released = intent.getExtras().getString("Released");
        double rating = intent.getExtras().getDouble("Rating");
        boolean favorite = intent.getExtras().getBoolean("Favorite");


        txtTitle.setText(movieTitle);
        txtDescription.setText(description);
        txtReleased.setText(new StringBuilder().append("Released: ").append(released).toString());
        Picasso.get().load(image).into(posterImage);
        rRating.setText(new StringBuilder().append("|  Rating: ").append(rating).toString());


        if (favCheckBox.isChecked()){
            MovieDatabase movieDAO = MovieDatabase.getDbInstance(this);
            //(int id, String imdb_id, String backdrop_path, List< Cast > cast, String original_title, String overview, String poster_path, String release_date, String title, double vote_average, boolean favourite)
            //Movie movie = new Movie(movieTitle,description,image,released,rating,favorite);
        }



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelected(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
//                case R.id.nowPlayingButton:
//                    startActivity(new Intent(getApplicationContext(), NowPlayingActivity.class));
//                    overridePendingTransition(0,0);
//                    return true;


                case R.id.popularButton:
                    startActivity(new Intent(getApplicationContext(), PopularMoviesActivity.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.favoriteMoviesButton:
                    startActivity(new Intent(getApplicationContext(), FavoriteMoviesActivity.class));
                    overridePendingTransition(0,0);
                    return true;

                case R.id.searchButton:
                    startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                    overridePendingTransition(0,0);
                    return true;
            }
            return false;
        });


    }





    @Override
    protected void runOperations() {

    }

    @Override
    protected void stopOperations() {

    }




}