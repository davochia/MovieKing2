package com.wisekingdavid.movieking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.ImageReader;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;
import com.wisekingdavid.movieking.model.AbstractActivity;


public class MovieActivity extends AbstractActivity {

    private TextView txtTitle, txtReleased, txtDescription, txtCategory, rRating;
    private ImageView posterImage;

    @Override
    protected int getLayout() {
        return R.layout.activity_movie;
    }

    @Override
    protected void initLayout() {

        txtTitle = findViewById(R.id.detailsTitle);
        txtReleased = findViewById(R.id.detailsRelease);
        txtDescription = findViewById(R.id.detailsDescription);
        //txtCategory = findViewById(R.id.detailsCategory);
        posterImage = findViewById(R.id.detailsImage);
        rRating = findViewById(R.id.detailsRating);


        Intent intent = getIntent();
        String movieTitle = intent.getExtras().getString("Title");
        String description = intent.getExtras().getString("Description");
        //String cat = intent.getExtras().getString("Category");
        String image = intent.getExtras().getString("Image");
        String released = intent.getExtras().getString("Released");
        double rating = intent.getExtras().getDouble("Rating");

        txtTitle.setText(movieTitle);
        txtDescription.setText(description);
        //txtCategory.setText(cat);
        txtReleased.setText(new StringBuilder().append("Released: ").append(released).toString());
        Picasso.get().load(image).into(posterImage);
        rRating.setText(new StringBuilder().append("|  Rating: ").append(rating).toString());


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelected(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
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